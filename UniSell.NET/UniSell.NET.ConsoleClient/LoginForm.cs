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
    public partial class LoginForm : Form
    {
        public LoginForm()
        {
            InitializeComponent();
        }

        private void loginButton_Click(object sender, EventArgs e)
        {
            string username = username_login.Text.ToString();
            string password = password_login.Text.ToString();
            if (string.IsNullOrEmpty(username) || string.IsNullOrEmpty(password))
            {
                showErrorMsg("Por favor, introduzca el nombre de usuario y contraseña", "Formulario no válido");
            } else
            {
                UserWSClient ws = new UserWSClient();
                string authToken = ws.login(username, password);
                if (string.IsNullOrEmpty(authToken))
                {
                    showErrorMsg("Credenciales de acceso incorrectas", "Login Incorrecto");
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
