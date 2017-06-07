namespace UniSell.NET.ConsoleClient
{
    partial class UserForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(UserForm));
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.user_name = new System.Windows.Forms.TextBox();
            this.user_surname = new System.Windows.Forms.TextBox();
            this.user_email = new System.Windows.Forms.TextBox();
            this.user_document = new System.Windows.Forms.TextBox();
            this.user_username = new System.Windows.Forms.TextBox();
            this.user_password = new System.Windows.Forms.TextBox();
            this.user_re_password = new System.Windows.Forms.TextBox();
            this.user_enabled = new System.Windows.Forms.CheckBox();
            this.user_document_type = new System.Windows.Forms.ComboBox();
            this.user_company = new System.Windows.Forms.ComboBox();
            this.user_company_label = new System.Windows.Forms.Label();
            this.save_user_button = new System.Windows.Forms.Button();
            this.user_clear_button = new System.Windows.Forms.Button();
            this.edit_user_button = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(33, 24);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(162, 25);
            this.label1.TabIndex = 0;
            this.label1.Text = "Datos de Usuario";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(36, 76);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(55, 15);
            this.label2.TabIndex = 1;
            this.label2.Text = "Nombre:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(345, 78);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(60, 15);
            this.label3.TabIndex = 2;
            this.label3.Text = "Apellidos:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(35, 136);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(42, 15);
            this.label4.TabIndex = 3;
            this.label4.Text = "Email:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(35, 190);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(74, 15);
            this.label5.TabIndex = 4;
            this.label5.Text = "Documento:";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(35, 245);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(53, 15);
            this.label7.TabIndex = 6;
            this.label7.Text = "Usuario:";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(35, 299);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(73, 15);
            this.label8.TabIndex = 7;
            this.label8.Text = "Contraseña:";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(341, 299);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(114, 15);
            this.label9.TabIndex = 8;
            this.label9.Text = "Repetir contraseña:";
            // 
            // user_name
            // 
            this.user_name.Location = new System.Drawing.Point(115, 76);
            this.user_name.Name = "user_name";
            this.user_name.Size = new System.Drawing.Size(198, 20);
            this.user_name.TabIndex = 9;
            this.user_name.Tag = "nombre";
            // 
            // user_surname
            // 
            this.user_surname.Location = new System.Drawing.Point(463, 76);
            this.user_surname.Name = "user_surname";
            this.user_surname.Size = new System.Drawing.Size(198, 20);
            this.user_surname.TabIndex = 10;
            this.user_surname.Tag = "apellidos";
            // 
            // user_email
            // 
            this.user_email.Location = new System.Drawing.Point(115, 131);
            this.user_email.Name = "user_email";
            this.user_email.Size = new System.Drawing.Size(198, 20);
            this.user_email.TabIndex = 11;
            this.user_email.Tag = "email";
            // 
            // user_document
            // 
            this.user_document.Location = new System.Drawing.Point(115, 185);
            this.user_document.Name = "user_document";
            this.user_document.Size = new System.Drawing.Size(198, 20);
            this.user_document.TabIndex = 12;
            this.user_document.Tag = "documento";
            // 
            // user_username
            // 
            this.user_username.Location = new System.Drawing.Point(115, 240);
            this.user_username.Name = "user_username";
            this.user_username.Size = new System.Drawing.Size(198, 20);
            this.user_username.TabIndex = 13;
            this.user_username.Tag = "usuario";
            // 
            // user_password
            // 
            this.user_password.Location = new System.Drawing.Point(115, 294);
            this.user_password.Name = "user_password";
            this.user_password.Size = new System.Drawing.Size(198, 20);
            this.user_password.TabIndex = 14;
            this.user_password.Tag = "contraseña";
            this.user_password.UseSystemPasswordChar = true;
            // 
            // user_re_password
            // 
            this.user_re_password.Location = new System.Drawing.Point(463, 294);
            this.user_re_password.Name = "user_re_password";
            this.user_re_password.Size = new System.Drawing.Size(198, 20);
            this.user_re_password.TabIndex = 15;
            this.user_re_password.Tag = "re-contraseña";
            this.user_re_password.UseSystemPasswordChar = true;
            // 
            // user_enabled
            // 
            this.user_enabled.AutoSize = true;
            this.user_enabled.Checked = true;
            this.user_enabled.CheckState = System.Windows.Forms.CheckState.Checked;
            this.user_enabled.Location = new System.Drawing.Point(463, 136);
            this.user_enabled.Name = "user_enabled";
            this.user_enabled.Size = new System.Drawing.Size(102, 19);
            this.user_enabled.TabIndex = 16;
            this.user_enabled.Text = "Cuenta activa";
            this.user_enabled.UseVisualStyleBackColor = true;
            // 
            // user_document_type
            // 
            this.user_document_type.FormattingEnabled = true;
            this.user_document_type.Location = new System.Drawing.Point(463, 185);
            this.user_document_type.Name = "user_document_type";
            this.user_document_type.Size = new System.Drawing.Size(198, 21);
            this.user_document_type.TabIndex = 17;
            this.user_document_type.Tag = "tipo de documento";
            // 
            // user_company
            // 
            this.user_company.FormattingEnabled = true;
            this.user_company.Location = new System.Drawing.Point(463, 236);
            this.user_company.Name = "user_company";
            this.user_company.Size = new System.Drawing.Size(198, 21);
            this.user_company.TabIndex = 18;
            this.user_company.Tag = "empresa";
            // 
            // user_company_label
            // 
            this.user_company_label.AutoSize = true;
            this.user_company_label.Location = new System.Drawing.Point(344, 240);
            this.user_company_label.Name = "user_company_label";
            this.user_company_label.Size = new System.Drawing.Size(60, 15);
            this.user_company_label.TabIndex = 19;
            this.user_company_label.Text = "Empresa:";
            // 
            // save_user_button
            // 
            this.save_user_button.BackColor = System.Drawing.Color.LightGreen;
            this.save_user_button.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.save_user_button.Location = new System.Drawing.Point(521, 347);
            this.save_user_button.Name = "save_user_button";
            this.save_user_button.Size = new System.Drawing.Size(140, 37);
            this.save_user_button.TabIndex = 20;
            this.save_user_button.Text = "Guardar";
            this.save_user_button.UseVisualStyleBackColor = false;
            this.save_user_button.Click += new System.EventHandler(this.save_user_button_Click);
            // 
            // user_clear_button
            // 
            this.user_clear_button.BackColor = System.Drawing.Color.LightCoral;
            this.user_clear_button.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.user_clear_button.Location = new System.Drawing.Point(404, 347);
            this.user_clear_button.Name = "user_clear_button";
            this.user_clear_button.Size = new System.Drawing.Size(111, 36);
            this.user_clear_button.TabIndex = 21;
            this.user_clear_button.Text = "Limpiar";
            this.user_clear_button.UseVisualStyleBackColor = false;
            this.user_clear_button.Click += new System.EventHandler(this.user_clear_button_Click);
            // 
            // edit_user_button
            // 
            this.edit_user_button.BackColor = System.Drawing.Color.LightGreen;
            this.edit_user_button.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.edit_user_button.Location = new System.Drawing.Point(521, 346);
            this.edit_user_button.Name = "edit_user_button";
            this.edit_user_button.Size = new System.Drawing.Size(140, 37);
            this.edit_user_button.TabIndex = 22;
            this.edit_user_button.Text = "Guardar";
            this.edit_user_button.UseVisualStyleBackColor = false;
            this.edit_user_button.Click += new System.EventHandler(this.edit_user_button_Click);
            // 
            // UserForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(733, 407);
            this.Controls.Add(this.edit_user_button);
            this.Controls.Add(this.user_clear_button);
            this.Controls.Add(this.save_user_button);
            this.Controls.Add(this.user_company_label);
            this.Controls.Add(this.user_company);
            this.Controls.Add(this.user_document_type);
            this.Controls.Add(this.user_enabled);
            this.Controls.Add(this.user_re_password);
            this.Controls.Add(this.user_password);
            this.Controls.Add(this.user_username);
            this.Controls.Add(this.user_document);
            this.Controls.Add(this.user_email);
            this.Controls.Add(this.user_surname);
            this.Controls.Add(this.user_name);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "UserForm";
            this.Text = "UniSell: Datos de Usuario";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.TextBox user_name;
        private System.Windows.Forms.TextBox user_surname;
        private System.Windows.Forms.TextBox user_email;
        private System.Windows.Forms.TextBox user_document;
        private System.Windows.Forms.TextBox user_username;
        private System.Windows.Forms.TextBox user_password;
        private System.Windows.Forms.TextBox user_re_password;
        private System.Windows.Forms.CheckBox user_enabled;
        private System.Windows.Forms.ComboBox user_document_type;
        private System.Windows.Forms.ComboBox user_company;
        private System.Windows.Forms.Label user_company_label;
        private System.Windows.Forms.Button save_user_button;
        private System.Windows.Forms.Button user_clear_button;
        private System.Windows.Forms.Button edit_user_button;
    }
}