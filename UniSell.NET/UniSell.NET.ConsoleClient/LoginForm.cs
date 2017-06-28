using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UniSell.NET.ConsoleClient.UserWS;

namespace UniSell.NET.ConsoleClient
{
    public partial class LoginForm : Form
    {
        public LoginForm()
        {
            InitializeComponent();
        }

        private void loginButton_Click(object sender1, EventArgs e)
        {
            string username = username_login.Text.ToString();
            string password = password_login.Text.ToString();
            if (string.IsNullOrEmpty(username) || string.IsNullOrEmpty(password))
            {
                showErrorMsg("Por favor, introduzca el nombre de usuario y contraseña", "Formulario no válido");
            } else
            {
                UserWSClient ws = new UserWSClient();
                try
                {
                    string authToken = ws.login(username, password);
                    if (string.IsNullOrEmpty(authToken))
                    {
                        showErrorMsg("Credenciales de acceso incorrectas", "Login Incorrecto");
                    }
                    else
                    {
                        this.Hide();
                        HomeForm homeForm = new HomeForm(authToken, this);
                        homeForm.Closed += (s, args) => this.Close();
                        homeForm.Show();
                    }
                } catch (Exception ex)
                {
                    showErrorMsg(ex.Message, "Error");
                }
            }
        }

        private void showErrorMsg(string msg, string title)
        {
            MessageBox.Show(msg,
                title,
                MessageBoxButtons.OK,
                MessageBoxIcon.Error);
        }
    }
}
