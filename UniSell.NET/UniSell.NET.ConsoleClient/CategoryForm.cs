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
using UniSell.NET.ConsoleClient.CategoryWS;

namespace UniSell.NET.ConsoleClient
{
    public partial class CategoryForm : Form
    {
        private string authToken;
        private HomeForm parentForm;
        private editCategoryData category;

        public CategoryForm(string authToken, HomeForm parentForm, editCategoryData category = null)
        {
            this.authToken = authToken;
            this.parentForm = parentForm;
            this.category = category;
            InitializeComponent();
            if (category != null)
            {
                InitializeEditData();
                saveCategoryBtn.Hide();
            } else
            {
                editCategoryBtn.Hide();
            }
        }

        private void InitializeEditData()
        {
            category_name.Text = category.categoryData.name;
        }

        private void saveCategoryBtn_Click(object sender, EventArgs e)
        {
            if (!ValidateFields())
            {
                return;
            }
            try
            {
                CategoryWSClient ws = new CategoryWSClient();
                ws.createCategory(new Security { BinarySecurityToken = authToken },
                    new createCategory { arg1 = new categoryData { name = category_name.Text } });
                parentForm.FilterCategoriesTable();
                this.Close();
            }
            catch (FaultException<RepeatedNameException> ex)
            {
                ShowExceptionError("Ya hay otra categoría con dicho nombre. Por favor, introduzca otro");
            }
            catch (FaultException<InvalidEntityException> ex)
            {
                ShowExceptionError("Error. No se han recibido todos los campos necesarios para completar la operación");
            }
        }

        private void clearCategory_Click(object sender, EventArgs e)
        {
            category_name.Clear();
        }

        private void editCategoryBtn_Click(object sender, EventArgs e)
        {
            if (!ValidateFields())
            {
                return;
            }
            try
            {
                CategoryWSClient ws = new CategoryWSClient();
                category.categoryData.name = category_name.Text;
                ws.editCategory(new Security { BinarySecurityToken = authToken },
                    new editCategory { arg1 = category });
                parentForm.FilterCategoriesTable();
                this.Close();
            }
            catch (FaultException<RepeatedNameException> ex)
            {
                ShowExceptionError("Ya hay otra categoría con dicho nombre. Por favor, introduzca otro");
            }
            catch (FaultException<InvalidEntityException> ex)
            {
                ShowExceptionError("Error. No se han recibido todos los campos necesarios para completar la operación");
            }
        }

        private bool ValidateFields()
        {
            if (string.IsNullOrEmpty(category_name.Text))
            {
                ShowExceptionError("Por favor, introduzca el nombre de la categoría");
                return false;
            }
            return true;
        }

        private void ShowExceptionError(string msg)
        {
            MessageBox.Show(msg,
                        "Error completando la operación",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
        }
    }
}
