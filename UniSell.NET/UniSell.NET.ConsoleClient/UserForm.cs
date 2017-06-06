using System;
using System.Dynamic;
using System.Windows.Forms;
using UniSell.NET.ConsoleClient.UniSellAdminWS;
using UniSell.NET.ConsoleClient.UniSellCompanyWS;
using UniSell.NET.ConsoleClient.UniSellSellerWS;

namespace UniSell.NET.ConsoleClient
{
    public partial class UserForm : Form
    {
        private dynamic user;
        private string authToken;
        private bool seller;
        private HomeForm parentForm;

        public UserForm(bool seller, string authToken, HomeForm form, dynamic user = null)
        {
            this.parentForm = form;
            this.seller = seller;
            this.authToken = authToken;
            InitializeComponent();
            InitializeDocumentCombobox(seller);
            InitializeCompanies(seller);
            if (!seller)
            {
                user_company.Hide();
                user_company_label.Hide();
            }
            if (user != null)
            {
                this.user = user;
                InitializeEditUser(seller);
                save_user_button.Hide();
            } else
            {
                edit_user_button.Hide();
            }
        }

        private void InitializeDocumentCombobox(bool seller)
        {
            dynamic docTypes = seller ? 
                Enum.GetValues(typeof(UniSellSellerWS.PersonIdDocumentType)) :
                Enum.GetValues(typeof(UniSellAdminWS.PersonIdDocumentType));
            if (docTypes != null)
            {
                foreach (var type in docTypes)
                {
                    user_document_type.Items.Add(type);
                }
            }
        }

        private void InitializeEditUser(bool seller)
        {
            dynamic source = seller ? user.userData.userData : user.userData;
            user_name.Text = source.name;
            user_surname.Text = source.surname;
            user_email.Text = source.email;
            user_enabled.Checked = source.accountEnabled;
            user_document.Text = source.idDocument;
            user_username.Text = source.username;
            user_document_type.SelectedIndex = user_document_type.FindStringExact(source.documentType + "");
            if (seller)
            {
                CompanyWSClient ws = new CompanyWSClient();
                findCompanyResponse res = ws.findCompany(new UniSellCompanyWS.Security { BinarySecurityToken = authToken },
                    new findCompany { arg1 = user.userData.companyId, arg1Specified = true });
                user_company.SelectedIndex = user_company.FindStringExact(res.@return.companyData.name);
            }
        }

        private void InitializeCompanies(bool seller)
        {
            if (seller)
            {
                CompanyWSClient ws = new CompanyWSClient();
                editCompanyData[] data = ws.listCompaniesByFilter(
                    new UniSellCompanyWS.Security { BinarySecurityToken = authToken }, 
                    new listCompaniesByFilter { arg1 = new CompanySearchFilter { } });
                if (data != null)
                {
                    foreach (var companyData in data) {
                        user_company.Items.Add(new CompanyComboboxItem {
                            Id= companyData.id,
                            Label = companyData.companyData.name
                        });
                    }
                }
            }
        }

        private void user_clear_button_Click(object sender, EventArgs e)
        {
            foreach (dynamic cntrl in Controls)
            {
                if (cntrl is TextBox)
                {
                    cntrl.Clear();
                } else if (cntrl is ComboBox)
                {
                    cntrl.SelectedIndex = -1;
                }
            }
        }

        private void edit_user_button_Click(object sender, EventArgs e)
        {
            if (seller)
            {
                UserSellerWSClient ws = new UserSellerWSClient();
                user.userData.companyId = ((CompanyComboboxItem)user_company.SelectedItem).Id;
                createUserData(user.userData.userData, user_document_type.SelectedItem);
                ws.editSeller(new UniSellSellerWS.Security { BinarySecurityToken = authToken }, 
                    new editSeller { arg1 = user });
            } else
            {
                UserAdminWSClient ws = new UserAdminWSClient();
                createUserData(user.userData, user_document_type.SelectedItem);
                ws.editAdmin(new UniSellAdminWS.Security { BinarySecurityToken = authToken }, 
                    new editAdmin { arg1 = user });
            }
            parentForm.FilterUsersTable();
            this.Close();
        }

        private void save_user_button_Click(object sender, EventArgs e)
        {
            if (seller)
            {
                UniSellSellerWS.userData ud = new UniSellSellerWS.userData();
                createUserData(ud, user_document_type.SelectedItem);
                UserSellerWSClient ws = new UserSellerWSClient();
                ws.createSeller(new UniSellSellerWS.Security { BinarySecurityToken = authToken },
                    new createSeller { arg1 = new userSellerData {
                        companyId = ((CompanyComboboxItem)user_company.SelectedItem).Id,
                        companyIdSpecified = true,
                        userData = ud
                    } });
            }
            else
            {
                UserAdminWSClient ws = new UserAdminWSClient();
                UniSellAdminWS.userData ud = new UniSellAdminWS.userData();
                createUserData(ud, user_document_type.SelectedItem);
                ws.createAdmin(new UniSellAdminWS.Security { BinarySecurityToken = authToken },
                    new createAdmin { arg1 = ud });
            }
            parentForm.FilterUsersTable();
            this.Close();
        }

        private void createUserData(dynamic ud, dynamic documentType)
        {
            ud.accountEnabled = user_enabled.Checked;
            ud.documentType = documentType;
            ud.email = user_email.Text;
            ud.idDocument = user_document.Text;
            ud.name = user_name.Text;
            ud.surname = user_surname.Text;
            ud.username = user_username.Text;
            ud.password = user_password.Text;
            ud.documentTypeSpecified = true;
        }
    }

    public class CompanyComboboxItem
    {
        public string Label { get; set; }
        public long Id { get; set; }

        public override string ToString()
        {
            return Label;
        }
    }
}
