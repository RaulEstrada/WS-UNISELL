using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UniSell.NET.ConsoleClient.UniSellWS;

namespace UniSell.NET.ConsoleClient
{
    public partial class HomeForm : Form
    {
        private Security Security;

        public HomeForm(string authToken)
        {
            this.Security = new Security { BinarySecurityToken = authToken };
            InitializeComponent();
            InitializeUserRolesCombobox();
            InitializeUserDocumentTypeCombobox();
            InitializeUserTableControls();
            FilterUsersTable();
        }

        private void InitializeUserRolesCombobox()
        {
            UserWSClient ws = new UserWSClient();
            UserRole?[] roles = ws.findUserRoles();
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
            PersonIdDocumentType?[] types = ws.findPersonDocumentTypes();
            if (types != null)
            {
                foreach (var type in types)
                {
                    document_type_filter.Items.Add(type);
                }
            }
        }

        private void InitializeUserTableControls()
        {
            userTable.Controls.Add(new Label() { Text = "Id" }, 0, 0);
            userTable.Controls.Add(new Label() { Text = "Nombre" }, 1, 0);
            userTable.Controls.Add(new Label() { Text = "Email" }, 2, 0);
            userTable.Controls.Add(new Label() { Text = "Doc." }, 3, 0);
            userTable.Controls.Add(new Label() { Text = "Usuario" }, 4, 0);
            userTable.Controls.Add(new Label() { Text = "Editar" }, 5, 0);
            userTable.Controls.Add(new Label() { Text = "Borrar" }, 6, 0);
            userTable.Controls.Add(new Label() { Text = "Activar" }, 7, 0);
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

        private void FilterUsersTable()
        {
            UserSearchFilter filter = new UserSearchFilter
            {
                Name = name_filter.Text.ToString(),
                Surname = surname_filter.Text.ToString(),
                Email = email_filter.Text.ToString(),
                Username = surname_filter.Text.ToString(),
                Role = rol_filter.Text.ToString(),
                IdDocument = document_filter.Text.ToString(),
                IdDocumentType = document_type_filter.Text.ToString()
            };
            UserWSClient ws = new UserWSClient();
            for (int indx = (userTable.RowCount * userTable.ColumnCount) - 1; indx >= userTable.ColumnCount ; indx--)
            {
                userTable.Controls.RemoveAt(indx);
            }
            userTable.RowCount = 1;
            editUserData[] users = ws.listUsersByFilter(Security, new listUsersByFilter { arg1 = filter });
            FillUsersTable(users);
        }

        private void FillUsersTable(editUserData[] users)
        {
            if (users == null)
            {
                return;
            }
            foreach (editUserData user in users)
            {
                Button editBtn = new Button{Text = "Editar"};
                Button removeBtn = new Button { Text = "Borrar" };
                Button activateBtn = new Button { Text = user.userData.accountEnabled ? "Desactivar" : "Activar" };
                userTable.RowCount++;
                userTable.Controls.Add(new Label() { Text = user.id.ToString()}, 0, userTable.RowCount - 1);
                userTable.Controls.Add(new Label() { Text = user.userData.name + " " + user.userData.surname }, 1, userTable.RowCount - 1);
                userTable.Controls.Add(new Label() { Text = user.userData.email }, 2, userTable.RowCount - 1);
                userTable.Controls.Add(new Label() { Text = user.userData.documentType + " " + user.userData.idDocument }, 3, userTable.RowCount - 1);
                userTable.Controls.Add(new Label() { Text = user.userData.username }, 4, userTable.RowCount - 1);
                userTable.Controls.Add(editBtn, 5, userTable.RowCount - 1);
                userTable.Controls.Add(removeBtn, 6, userTable.RowCount - 1);
                userTable.Controls.Add(activateBtn, 7, userTable.RowCount - 1);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            FilterUsersTable();
        }
    }
}
