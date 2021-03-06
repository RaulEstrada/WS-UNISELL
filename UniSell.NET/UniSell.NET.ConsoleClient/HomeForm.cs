﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Dynamic;
using System.Linq;
using System.ServiceModel;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UniSell.NET.ConsoleClient.AdminWS;
using UniSell.NET.ConsoleClient.CategoryWS;
using UniSell.NET.ConsoleClient.CompanyWS;
using UniSell.NET.ConsoleClient.SellerWS;
using UniSell.NET.ConsoleClient.UserWS;

namespace UniSell.NET.ConsoleClient
{
    public partial class HomeForm : Form
    {
        private string authToken;
        private LoginForm parentForm;

        public HomeForm(string authToken, LoginForm parentForm)
        {
            this.authToken = authToken;
            this.parentForm = parentForm;
            InitializeComponent();
            InitializeUserRolesCombobox();
            InitializeUserDocumentTypeCombobox();
            InitializeCompanyDocumentTypeCombobox();
            InitializeUserTableControls();
            InitializeCompanyTableControls();
            InitializeCategoryTableControls();
            FilterUsersTable();
            FilterCompaniesTable();
            FilterCategoriesTable();
        }

        private void InitializeUserRolesCombobox()
        {
            UserWSClient ws = new UserWSClient();
            UserWS.UserRole?[] roles = ws.findUserRoles();
            if (roles != null)
            {
                foreach (var rol in roles)
                {
                    rol_filter.Items.Add(rol);
                }
            }
        }

        private void InitializeUserDocumentTypeCombobox()
        {
            UserWSClient ws = new UserWSClient();
            UserWS.PersonIdDocumentType?[] types = ws.findPersonDocumentTypes();
            if (types != null)
            {
                foreach (var type in types)
                {
                    document_type_filter.Items.Add(type);
                }
            }
        }

        private void InitializeCompanyDocumentTypeCombobox()
        {
            var types = Enum.GetValues(typeof(CompanyWS.LegalPersonIdDocumentType));
            foreach (var type in types)
            {
                comp_document_type.Items.Add(type);
            }
        }

        private void InitializeUserTableControls()
        {
            userTable.Controls.Add(new Label() { Text = "Id" }, 0, 0);
            userTable.Controls.Add(new Label() { Text = "Nombre" }, 1, 0);
            userTable.Controls.Add(new Label() { Text = "Email" }, 2, 0);
            userTable.Controls.Add(new Label() { Text = "Doc." }, 3, 0);
            userTable.Controls.Add(new Label() { Text = "Usuario" }, 4, 0);
            userTable.Controls.Add(new Label() { Text = "Rol" }, 5, 0);
            userTable.Controls.Add(new Label() { Text = "Editar" }, 6, 0);
            userTable.Controls.Add(new Label() { Text = "Borrar" }, 7, 0);
            userTable.Controls.Add(new Label() { Text = "Activar" }, 8, 0);
        }

        private void InitializeCompanyTableControls()
        {
            companiesTable.Controls.Add(new Label() { Text = "Id" }, 0, 0);
            companiesTable.Controls.Add(new Label() { Text = "Nombre" }, 1, 0);
            companiesTable.Controls.Add(new Label() { Text = "Ciudad" }, 2, 0);
            companiesTable.Controls.Add(new Label() { Text = "Región" }, 3, 0);
            companiesTable.Controls.Add(new Label() { Text = "País" }, 4, 0);
            companiesTable.Controls.Add(new Label() { Text = "Código Postal" }, 5, 0);
            companiesTable.Controls.Add(new Label() { Text = "Documento" }, 6, 0);
            companiesTable.Controls.Add(new Label() { Text = "Editar" }, 7, 0);
            companiesTable.Controls.Add(new Label() { Text = "Borrar" }, 8, 0);
        }

        private void InitializeCategoryTableControls()
        {
            categoriesTable.Controls.Add(new Label() { Text = "Name" }, 0, 0);
            categoriesTable.Controls.Add(new Label() { Text = "Editar" }, 1, 0);
            categoriesTable.Controls.Add(new Label() { Text = "Borrar" }, 2, 0);
        }

        private void Tab_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (Inicio.SelectedTab.Equals(usersTab))
            {
                
            }
            else if (Inicio.SelectedTab.Equals(companiesTab))
            {
                
            }
        }

        public void FilterUsersTable()
        {
            UserSearchFilter filter = new UserSearchFilter
            {
                Name = name_filter.Text.ToString(),
                Surname = surname_filter.Text.ToString(),
                Email = email_filter.Text.ToString(),
                Username = surname_filter.Text.ToString(),
                Roles = new string[] { rol_filter.Text.ToString() },
                IdDocument = document_filter.Text.ToString(),
                IdDocumentType = document_type_filter.Text.ToString()
            };
            UserWSClient ws = new UserWSClient();
            for (int indx = (userTable.RowCount * userTable.ColumnCount) - 1; indx >= userTable.ColumnCount ; indx--)
            {
                userTable.Controls.RemoveAt(indx);
            }
            userTable.RowCount = 1;
            UserWS.editUserData[] users = ws.listUsersByFilter(new UserWS.Security { BinarySecurityToken = authToken }, new listUsersByFilter { arg1 = filter });
            FillUsersTable(users);
        }

        private void FillUsersTable(UserWS.editUserData[] users)
        {
            if (users == null)
            {
                return;
            }
            foreach (UserWS.editUserData user in users)
            {
                dynamic editTag = new ExpandoObject();
                editTag.id = user.id;
                editTag.role = user.userData.role;
                Button editBtn = new Button{Text = "Editar", Tag = editTag };
                editBtn.Click += EditUser;
                Button removeBtn = new Button { Text = "Borrar", Tag = user.id };
                removeBtn.Click += DeleteUser;
                dynamic activateTag = new ExpandoObject();
                activateTag.id = user.id;
                activateTag.enabled = user.userData.accountEnabled;
                Button activateBtn = new Button {
                    Text = user.userData.accountEnabled ? "Desactivar" : "Activar",
                    Tag = activateTag
                };
                activateBtn.Click += ActivateUser;
                userTable.RowCount++;
                userTable.Controls.Add(new Label() { Text = user.id.ToString()}, 0, userTable.RowCount - 1);
                userTable.Controls.Add(new Label() { Text = user.userData.name + " " + user.userData.surname }, 1, userTable.RowCount - 1);
                userTable.Controls.Add(new Label() { Text = user.userData.email }, 2, userTable.RowCount - 1);
                userTable.Controls.Add(new Label() { Text = user.userData.documentType + " " + user.userData.idDocument }, 3, userTable.RowCount - 1);
                userTable.Controls.Add(new Label() { Text = user.userData.username }, 4, userTable.RowCount - 1);
                userTable.Controls.Add(new Label() { Text = user.userData.role.ToString() }, 5, userTable.RowCount - 1);
                userTable.Controls.Add(editBtn, 6, userTable.RowCount - 1);
                userTable.Controls.Add(removeBtn, 7, userTable.RowCount - 1);
                userTable.Controls.Add(activateBtn, 8, userTable.RowCount - 1);
            }
        }

        public void FilterCompaniesTable()
        {
            CompanySearchFilter filter = new CompanySearchFilter
            {
                Name = comp_name.Text,
                Description = comp_desc.Text,
                City = comp_city.Text,
                Region = comp_region.Text,
                Country = comp_country.Text,
                ZipCode = comp_zipcode.Text,
                IdDocument = comp_document.Text,
                IdDocumentType = comp_document_type.Text
            };
            CompanyWSClient ws = new CompanyWSClient();
            for (int indx = (companiesTable.RowCount * companiesTable.ColumnCount) - 1; indx >= companiesTable.ColumnCount; indx--)
            {
                companiesTable.Controls.RemoveAt(indx);
            }
            companiesTable.RowCount = 1;
            editCompanyData[] data = ws.listCompaniesByFilter(new CompanyWS.Security { BinarySecurityToken = authToken },
                new listCompaniesByFilter { arg1 = filter });
            FillCompaniesTable(data);
        }

        public void FilterCategoriesTable()
        {
            CategoryWSClient ws = new CategoryWSClient();
            for (int indx = (categoriesTable.RowCount * categoriesTable.ColumnCount) - 1; indx >= categoriesTable.ColumnCount; indx--)
            {
                categoriesTable.Controls.RemoveAt(indx);
            }
            categoriesTable.RowCount = 1;
            editCategoryData[] data = ws.listCategoriesByName(new CategoryWS.Security { BinarySecurityToken = authToken },
                new listCategoriesByName { arg1 = category_filter_name.Text });
            FillCategoryTable(data);
        }

        private void FillCompaniesTable(editCompanyData[] companies)
        {
            if (companies == null)
            {
                return;
            }
            foreach (var company in companies)
            {
                Button editBtn = new Button { Text = "Editar", Tag = company.id };
                editBtn.Click += EditCompany;
                Button removeBtn = new Button { Text = "Borrar", Tag = company.id };
                removeBtn.Click += DeleteCompany;
                companiesTable.RowCount++;
                companiesTable.Controls.Add(new Label() { Text = company.id.ToString() }, 0, companiesTable.RowCount - 1);
                companiesTable.Controls.Add(new Label() { Text = company.companyData.name }, 1, companiesTable.RowCount - 1);
                companiesTable.Controls.Add(new Label() { Text = company.companyData.locationInfo.City }, 2, companiesTable.RowCount - 1);
                companiesTable.Controls.Add(new Label() { Text = company.companyData.locationInfo.Region }, 3, companiesTable.RowCount - 1);
                companiesTable.Controls.Add(new Label() { Text = company.companyData.locationInfo.Country }, 4, companiesTable.RowCount - 1);
                companiesTable.Controls.Add(new Label() { Text = company.companyData.locationInfo.ZipCode }, 5, companiesTable.RowCount - 1);
                companiesTable.Controls.Add(new Label() { Text = company.companyData.idDocumentType + " " + company.companyData.idDocument }, 6, companiesTable.RowCount - 1);
                companiesTable.Controls.Add(editBtn, 7, companiesTable.RowCount - 1);
                companiesTable.Controls.Add(removeBtn, 8, companiesTable.RowCount - 1);
            }
        }

        private void FillCategoryTable(editCategoryData[] data)
        {
            if (data == null)
            {
                return;
            }
            foreach (var category in data)
            {
                Button editBtn = new Button { Text = "Editar", Tag = category.id };
                editBtn.Click += EditCategory;
                Button removeBtn = new Button { Text = "Borrar", Tag = category.id };
                removeBtn.Click += DeleteCategory;
                categoriesTable.RowCount++;
                categoriesTable.Controls.Add(new Label() { Text = category.categoryData.name }, 0, categoriesTable.RowCount - 1);
                categoriesTable.Controls.Add(editBtn, 1, categoriesTable.RowCount - 1);
                categoriesTable.Controls.Add(removeBtn, 2, categoriesTable.RowCount - 1);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            FilterUsersTable();
        }

        private void DeleteCategory(dynamic sender, EventArgs e)
        {
            var confirmResult = MessageBox.Show("Está a punto de eliminar una categoría de productos. " +
                "Esta acción no se podrá deshacer. ¿Desea continuar con la operación?",
                "Confirmar borrado",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning);
            if (confirmResult == DialogResult.Yes)
            {
                long id = sender.Tag;
                CategoryWSClient ws = new CategoryWSClient();
                try
                {
                    removeCategoryResponse response = ws.removeCategory(new CategoryWS.Security { BinarySecurityToken = authToken },
                        new removeCategory { arg1 = id, arg1Specified = true });
                    FilterCategoriesTable();
                }
                catch (FaultException<CategoryWS.ElementNotFoundException> ex)
                {
                    MessageBox.Show("Ha ocurrido un error. No se ha encontrado una categoría con id " + id + " en el sistema",
                        "Error",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                }
                catch (FaultException<CategoryWS.ArgumentException> ex)
                {
                    MessageBox.Show("Ha ocurrido un error. No se ha recibido el id de la categoría a eliminar",
                        "Error",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                }
                catch (FaultException<CategoryWS.CannotRemoveElementException> ex)
                {
                    MessageBox.Show("Ha ocurrido un error. No se puede eliminar la categoría porque tiene productos asociados",
                        "Error",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                }
            }
        }

        private void DeleteUser(dynamic sender, EventArgs e)
        {
            var confirmResult = MessageBox.Show("Está a punto de eliminar un usuario. " +
                "Esta acción no se podrá deshacer. ¿Desea continuar con la operación?",
                "Confirmar borrado",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning);
            if (confirmResult == DialogResult.Yes)
            {
                long id = sender.Tag;
                UserWSClient ws = new UserWSClient();
                try
                {
                    removeUserResponse response = ws.removeUser(new UserWS.Security { BinarySecurityToken = authToken }, new removeUser { arg1 = id,  arg1Specified = true });
                    FilterUsersTable();
                }
                catch (FaultException<UserWS.ElementNotFoundException> ex)
                {
                    MessageBox.Show("Ha ocurrido un error. No se ha encontrado un usuario con id " + id + " en el sistema",
                        "Error",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                }
                catch (FaultException<UserWS.ArgumentException> ex)
                {
                    MessageBox.Show("Ha ocurrido un error. No se ha recibido el id del usuario a eliminar",
                        "Error",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                }
                catch (FaultException<UserWS.CannotRemoveElementException> ex)
                {
                    MessageBox.Show("Ha ocurrido un error. No se puede eliminar al vendedor porque ha creado productos",
                        "Error",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                }
            }
        }

        private void ActivateUser(dynamic sender, EventArgs e)
        {
            long id = sender.Tag.id;
            bool enabled = sender.Tag.enabled;
            UserWSClient ws = new UserWSClient();
            try
            {
                if (enabled)
                {
                    ws.disableAccount(new UserWS.Security { BinarySecurityToken = authToken }, new disableAccount { arg1 = id, arg1Specified = true });
                }
                else
                {
                    ws.enableAccount(new UserWS.Security { BinarySecurityToken = authToken }, new enableAccount { arg1 = id, arg1Specified = true });
                }
                FilterUsersTable();
            } catch (FaultException<UserWS.ArgumentException> ex)
            {
                MessageBox.Show("Ha ocurrido un error. No se ha recibido el id del usuario a eliminar",
                        "Error",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
            }
            catch (FaultException<UserWS.UnauthorizedAccessException> ex)
            {
                MessageBox.Show("Ha ocurrido un error. No está autorizado a realizar esta operación",
                        "Error",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
            }
        }

        private void EditUser(dynamic sender, EventArgs e)
        {
            long id = sender.Tag.id;
            UserWS.UserRole role = sender.Tag.role;
            dynamic user = null;
            if (role == UserWS.UserRole.SELLER)
            {
                UserSellerWSClient ws = new UserSellerWSClient();
                findSellerResponse res = ws.findSeller(new SellerWS.Security { BinarySecurityToken = authToken }, new findSeller { arg1 = id, arg1Specified = true });
                user = res.@return;
            } else
            {
                UserAdminWSClient ws = new UserAdminWSClient();
                findAdminResponse res = ws.findAdmin(new AdminWS.Security { BinarySecurityToken = authToken }, new findAdmin { arg1 = id, arg1Specified = true });
                user = res.@return;
            }
            UserForm form = new UserForm(role == UserWS.UserRole.SELLER, authToken, this, user);
            form.Show();
        }

        private void EditCategory(dynamic sender, EventArgs e)
        {
            long id = sender.Tag;
            CategoryWSClient ws = new CategoryWSClient();
            findCategoryResponse res = ws.findCategory(new CategoryWS.Security { BinarySecurityToken = authToken },
                new findCategory { arg1 = id, arg1Specified = true });
            CategoryForm form = new CategoryForm(authToken, this, res.@return);
            form.Show();
        }

        private void EditCompany(dynamic sender, EventArgs e)
        {
            long id = sender.Tag;
            CompanyWSClient ws = new CompanyWSClient();
            findCompanyResponse res = ws.findCompany(new CompanyWS.Security { BinarySecurityToken = authToken },
                new findCompany { arg1 = id, arg1Specified = true });
            CompanyForm form = new CompanyForm(authToken, this, res.@return);
            form.Show();
        }

        private void newAdminButton_Click(object sender, EventArgs e)
        {
            UserForm form = new UserForm(false, authToken, this);
            form.Show();
        }

        private void newSellerButton_Click(object sender, EventArgs e)
        {
            UserForm form = new UserForm(true, authToken, this);
            form.Show();
        }

        private void filterCompanies_Click(object sender, EventArgs e)
        {
            FilterCompaniesTable();
        }

        private void DeleteCompany(dynamic sender, EventArgs e)
        {
            long id = sender.Tag;
            UserSellerWSClient ws = new UserSellerWSClient();
            editUserSellerData[] sellers = ws.findSellersByCompanyId(new SellerWS.Security { BinarySecurityToken = authToken },
                new findSellersByCompanyId { arg1 = id, arg1Specified = true });
            if (sellers != null && sellers.Length > 0)
            {
                MessageBox.Show("No se puede eliminar la empresa. Todavía tiene usuarios asociados cuyos documentos son: " +
                    string.Join(", ", sellers.Select(seller => seller.userData.userData.idDocument)),
                    "No se puede borrar empresa",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
                return;
            }
            var confirmResult = MessageBox.Show("Está a punto de eliminar una empresa. " +
                "Esta acción no se podrá deshacer. ¿Desea continuar con la operación?",
                "Confirmar borrado",
                MessageBoxButtons.YesNo,
                MessageBoxIcon.Warning);
            if (confirmResult == DialogResult.Yes)
            {
                CompanyWSClient companyWS = new CompanyWSClient();
                try
                {
                    removeCompanyResponse response = companyWS.removeCompany(new CompanyWS.Security { BinarySecurityToken = authToken },
                        new removeCompany { arg1 = id, arg1Specified = true });
                    FilterCompaniesTable();
                }
                catch (FaultException<CompanyWS.ElementNotFoundException> ex)
                {
                    MessageBox.Show("Ha ocurrido un error. No se ha encontrado una empresa con id " + id + " en el sistema",
                        "Error",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                }
                catch (FaultException<CompanyWS.ArgumentException> ex)
                {
                    MessageBox.Show("Ha ocurrido un error. No se ha recibido el id de la empresa a eliminar",
                        "Error",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                }
                catch (FaultException<CompanyWS.CannotRemoveElementException> ex)
                {
                    MessageBox.Show("Ha ocurrido un error. No se puede eliminar la empresa porque todavía tiene usuarios asociados",
                        "Error",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                }
            }
        }

        private void newCompanyButton_Click(object sender, EventArgs e)
        {
            new CompanyForm(authToken, this).Show();
        }

        private void filterCategoriesButton_Click(object sender, EventArgs e)
        {
            FilterCategoriesTable();
        }

        private void newCategoryBtn_Click(object sender, EventArgs e)
        {
            new CategoryForm(authToken, this).Show();
        }

        private void logoutButton_Click(object sender, EventArgs e)
        {
            new LoginForm().Show();
            this.Dispose();
        }
    }
}
