using System;
using System.Windows.Forms;
using UniSell.NET.ConsoleClient.UniSellCompanyWS;

namespace UniSell.NET.ConsoleClient
{
    public partial class UserForm : Form
    {
        private dynamic user;
        private string authToken;

        public UserForm(bool seller, string authToken, dynamic user = null)
        {
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
        }

        private void InitializeCompanies(bool seller)
        {
            if (seller)
            {
                CompanyWSClient ws = new CompanyWSClient();
                editCompanyData[] data = ws.listCompaniesByFilter(
                    new Security { BinarySecurityToken = authToken }, 
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
