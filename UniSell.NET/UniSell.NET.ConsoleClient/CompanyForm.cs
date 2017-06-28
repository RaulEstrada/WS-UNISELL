using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UniSell.NET.ConsoleClient.CompanyWS;

namespace UniSell.NET.ConsoleClient
{
    public partial class CompanyForm : Form
    {
        private editCompanyData company;
        private string authToken;
        private HomeForm parentForm;

        public CompanyForm(string authToken, HomeForm parentForm, editCompanyData company = null)
        {
            this.authToken = authToken;
            this.company = company;
            this.parentForm = parentForm;
            InitializeComponent();
            InitializeDocumentTypeCombo();
            if (company != null)
            {
                InitializeEditData();
                save_company_button.Hide();
            } else
            {
                edit_company_button.Hide();
            }
        }

        private void InitializeDocumentTypeCombo()
        {
            var types = Enum.GetValues(typeof(LegalPersonIdDocumentType));
            foreach (var type in types)
            {
                com_doc_type.Items.Add(type);
            }
        }

        private void InitializeEditData()
        {
            com_name.Text = company.companyData.name;
            com_desc.Text = company.companyData.description;
            com_doc.Text = company.companyData.idDocument;
            com_doc_type.SelectedIndex = com_doc_type.FindStringExact(company.companyData.idDocumentType + "");
            com_city.Text = company.companyData.locationInfo.City;
            com_region.Text = company.companyData.locationInfo.Region;
            com_country.Text = company.companyData.locationInfo.Country;
            com_zipcode.Text = company.companyData.locationInfo.ZipCode;
        }

        private void ShowExceptionError(string msg)
        {
            MessageBox.Show(msg,
                        "Error completando la operación",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
        }

        private void save_company_button_Click(object sender, EventArgs e)
        {
            if (!ValidateEmptyFields())
            {
                return;
            }
            try
            {
                CompanyWSClient ws = new CompanyWSClient();
                companyData companyData = new companyData();
                completeCompanyData(companyData);
                ws.createCompany(new Security { BinarySecurityToken = authToken },
                    new createCompany { arg1 = companyData });
                parentForm.FilterCompaniesTable();
                this.Close();
            }
            catch (FaultException<RepeatedDocumentException> ex)
            {
                ShowExceptionError("Ya hay otra empresa con dicho documento. Por favor, introduzca otro");
            }
            catch (FaultException<InvalidEntityException> ex)
            {
                ShowExceptionError("Error. No se han recibido todos los campos necesarios para completar la operación");
            }
        }

        private void edit_company_button_Click(object sender, EventArgs e)
        {
            if (!ValidateEmptyFields())
            {
                return;
            }
            try
            {
                CompanyWSClient ws = new CompanyWSClient();
                completeCompanyData(company.companyData);
                ws.editCompany(new Security { BinarySecurityToken = authToken },
                    new editCompany { arg1 = company });
                parentForm.FilterCompaniesTable();
                this.Close();
            } catch (FaultException<RepeatedDocumentException> ex)
            {
                ShowExceptionError("Ya hay otra empresa con dicho documento. Por favor, introduzca otro");
            }
            catch (FaultException<InvalidEntityException> ex)
            {
                ShowExceptionError("Error. No se han recibido todos los campos necesarios para completar la operación");
            }
        }

        private void completeCompanyData(companyData data)
        {
            data.name = com_name.Text;
            data.description = com_desc.Text;
            data.idDocument = com_doc.Text;
            data.idDocumentType = (LegalPersonIdDocumentType)com_doc_type.SelectedItem;
            data.idDocumentTypeSpecified = true;
            data.locationInfo = new LocationInfo
            {
                City = com_city.Text,
                Region = com_region.Text,
                Country = com_country.Text,
                ZipCode = com_zipcode.Text
            };
        }

        private void clear_company_button_Click(object sender, EventArgs e)
        {
            foreach (dynamic cntrl in Controls)
            {
                if (cntrl is TextBox)
                {
                    cntrl.Clear();
                }
                else if (cntrl is ComboBox)
                {
                    cntrl.SelectedIndex = -1;
                }
            }
        }

        private bool ValidateEmptyFields()
        {
            IList<String> invalidFields = getEmptyFields();
            if (invalidFields.Count > 0)
            {
                MessageBox.Show("Por favor, introduzca los siguientes campos en el formulario: " +
                string.Join(", ", invalidFields),
                        "Datos no válidos",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                return false;
            }
            return true;
        }

        private IList<string> getEmptyFields()
        {
            IList<String> emptyFields = new List<String>();
            foreach (dynamic cntrl in Controls)
            {
                if (cntrl is TextBox && string.IsNullOrEmpty(cntrl.Text))
                {
                    emptyFields.Insert(0, cntrl.Tag);
                }
                else if (cntrl is ComboBox && cntrl.SelectedIndex == -1)
                {
                    emptyFields.Insert(0, cntrl.Tag);
                }
            }
            return emptyFields;
        }
    }
}
