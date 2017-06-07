namespace UniSell.NET.ConsoleClient
{
    partial class HomeForm
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(HomeForm));
            this.Inicio = new System.Windows.Forms.TabControl();
            this.homeTab = new System.Windows.Forms.TabPage();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.usersTab = new System.Windows.Forms.TabPage();
            this.newSellerButton = new System.Windows.Forms.Button();
            this.newAdminButton = new System.Windows.Forms.Button();
            this.userTable = new System.Windows.Forms.TableLayoutPanel();
            this.button1 = new System.Windows.Forms.Button();
            this.document_type_filter = new System.Windows.Forms.ComboBox();
            this.document_filter = new System.Windows.Forms.TextBox();
            this.label9 = new System.Windows.Forms.Label();
            this.rol_filter = new System.Windows.Forms.ComboBox();
            this.label8 = new System.Windows.Forms.Label();
            this.username_filter = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.email_filter = new System.Windows.Forms.TextBox();
            this.surname_filter = new System.Windows.Forms.TextBox();
            this.surname_label = new System.Windows.Forms.Label();
            this.name_filter = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.companiesTab = new System.Windows.Forms.TabPage();
            this.label1 = new System.Windows.Forms.Label();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.Inicio.SuspendLayout();
            this.homeTab.SuspendLayout();
            this.usersTab.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.SuspendLayout();
            // 
            // Inicio
            // 
            this.Inicio.Controls.Add(this.homeTab);
            this.Inicio.Controls.Add(this.usersTab);
            this.Inicio.Controls.Add(this.companiesTab);
            this.Inicio.Location = new System.Drawing.Point(12, 79);
            this.Inicio.Name = "Inicio";
            this.Inicio.SelectedIndex = 0;
            this.Inicio.Size = new System.Drawing.Size(828, 497);
            this.Inicio.TabIndex = 0;
            this.Inicio.SelectedIndexChanged += new System.EventHandler(this.Tab_SelectedIndexChanged);
            // 
            // homeTab
            // 
            this.homeTab.Controls.Add(this.label3);
            this.homeTab.Controls.Add(this.label2);
            this.homeTab.Location = new System.Drawing.Point(4, 22);
            this.homeTab.Name = "homeTab";
            this.homeTab.Padding = new System.Windows.Forms.Padding(3);
            this.homeTab.Size = new System.Drawing.Size(820, 471);
            this.homeTab.TabIndex = 0;
            this.homeTab.Text = "Inicio";
            this.homeTab.UseVisualStyleBackColor = true;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(25, 65);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(789, 220);
            this.label3.TabIndex = 1;
            this.label3.Text = resources.GetString("label3.Text");
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(20, 19);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(291, 25);
            this.label2.TabIndex = 0;
            this.label2.Text = "Gestión de usuarios y empresas";
            // 
            // usersTab
            // 
            this.usersTab.Controls.Add(this.newSellerButton);
            this.usersTab.Controls.Add(this.newAdminButton);
            this.usersTab.Controls.Add(this.userTable);
            this.usersTab.Controls.Add(this.button1);
            this.usersTab.Controls.Add(this.document_type_filter);
            this.usersTab.Controls.Add(this.document_filter);
            this.usersTab.Controls.Add(this.label9);
            this.usersTab.Controls.Add(this.rol_filter);
            this.usersTab.Controls.Add(this.label8);
            this.usersTab.Controls.Add(this.username_filter);
            this.usersTab.Controls.Add(this.label7);
            this.usersTab.Controls.Add(this.label6);
            this.usersTab.Controls.Add(this.email_filter);
            this.usersTab.Controls.Add(this.surname_filter);
            this.usersTab.Controls.Add(this.surname_label);
            this.usersTab.Controls.Add(this.name_filter);
            this.usersTab.Controls.Add(this.label5);
            this.usersTab.Controls.Add(this.label4);
            this.usersTab.Location = new System.Drawing.Point(4, 22);
            this.usersTab.Name = "usersTab";
            this.usersTab.Padding = new System.Windows.Forms.Padding(3);
            this.usersTab.Size = new System.Drawing.Size(820, 471);
            this.usersTab.TabIndex = 1;
            this.usersTab.Text = "Usuarios";
            this.usersTab.UseVisualStyleBackColor = true;
            // 
            // newSellerButton
            // 
            this.newSellerButton.BackColor = System.Drawing.Color.PaleGreen;
            this.newSellerButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.newSellerButton.Location = new System.Drawing.Point(178, 421);
            this.newSellerButton.Name = "newSellerButton";
            this.newSellerButton.Size = new System.Drawing.Size(144, 39);
            this.newSellerButton.TabIndex = 17;
            this.newSellerButton.Text = "Nuevo vendedor";
            this.newSellerButton.UseVisualStyleBackColor = false;
            this.newSellerButton.Click += new System.EventHandler(this.newSellerButton_Click);
            // 
            // newAdminButton
            // 
            this.newAdminButton.BackColor = System.Drawing.Color.LightGreen;
            this.newAdminButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.newAdminButton.Location = new System.Drawing.Point(26, 421);
            this.newAdminButton.Name = "newAdminButton";
            this.newAdminButton.Size = new System.Drawing.Size(145, 39);
            this.newAdminButton.TabIndex = 16;
            this.newAdminButton.Text = "Nuevo admin";
            this.newAdminButton.UseVisualStyleBackColor = false;
            this.newAdminButton.Click += new System.EventHandler(this.newAdminButton_Click);
            // 
            // userTable
            // 
            this.userTable.AutoScroll = true;
            this.userTable.ColumnCount = 9;
            this.userTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.userTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.userTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.userTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.userTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.userTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.userTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.userTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.userTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.userTable.Location = new System.Drawing.Point(23, 166);
            this.userTable.Name = "userTable";
            this.userTable.RowCount = 1;
            this.userTable.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.userTable.Size = new System.Drawing.Size(731, 244);
            this.userTable.TabIndex = 15;
            // 
            // button1
            // 
            this.button1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.button1.Location = new System.Drawing.Point(597, 98);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(157, 32);
            this.button1.TabIndex = 14;
            this.button1.Text = "Filtrar";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // document_type_filter
            // 
            this.document_type_filter.FormattingEnabled = true;
            this.document_type_filter.Location = new System.Drawing.Point(352, 107);
            this.document_type_filter.Name = "document_type_filter";
            this.document_type_filter.Size = new System.Drawing.Size(157, 21);
            this.document_type_filter.TabIndex = 13;
            // 
            // document_filter
            // 
            this.document_filter.Location = new System.Drawing.Point(94, 110);
            this.document_filter.Name = "document_filter";
            this.document_filter.Size = new System.Drawing.Size(157, 20);
            this.document_filter.TabIndex = 12;
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(20, 110);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(74, 15);
            this.label9.TabIndex = 11;
            this.label9.Text = "Documento:";
            // 
            // rol_filter
            // 
            this.rol_filter.FormattingEnabled = true;
            this.rol_filter.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.rol_filter.Location = new System.Drawing.Point(352, 79);
            this.rol_filter.Name = "rol_filter";
            this.rol_filter.Size = new System.Drawing.Size(157, 21);
            this.rol_filter.TabIndex = 10;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(284, 79);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(29, 15);
            this.label8.TabIndex = 9;
            this.label8.Text = "Rol:";
            // 
            // username_filter
            // 
            this.username_filter.Location = new System.Drawing.Point(94, 79);
            this.username_filter.Name = "username_filter";
            this.username_filter.Size = new System.Drawing.Size(157, 20);
            this.username_filter.TabIndex = 8;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(23, 79);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(53, 15);
            this.label7.TabIndex = 7;
            this.label7.Text = "Usuario:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(549, 47);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(42, 15);
            this.label6.TabIndex = 6;
            this.label6.Text = "Email:";
            // 
            // email_filter
            // 
            this.email_filter.Location = new System.Drawing.Point(597, 47);
            this.email_filter.Name = "email_filter";
            this.email_filter.Size = new System.Drawing.Size(157, 20);
            this.email_filter.TabIndex = 5;
            // 
            // surname_filter
            // 
            this.surname_filter.Location = new System.Drawing.Point(352, 47);
            this.surname_filter.Name = "surname_filter";
            this.surname_filter.Size = new System.Drawing.Size(157, 20);
            this.surname_filter.TabIndex = 4;
            // 
            // surname_label
            // 
            this.surname_label.AutoSize = true;
            this.surname_label.Location = new System.Drawing.Point(286, 47);
            this.surname_label.Name = "surname_label";
            this.surname_label.Size = new System.Drawing.Size(60, 15);
            this.surname_label.TabIndex = 3;
            this.surname_label.Text = "Apellidos:";
            // 
            // name_filter
            // 
            this.name_filter.Location = new System.Drawing.Point(94, 47);
            this.name_filter.Name = "name_filter";
            this.name_filter.Size = new System.Drawing.Size(157, 20);
            this.name_filter.TabIndex = 2;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(20, 47);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(55, 15);
            this.label5.TabIndex = 1;
            this.label5.Text = "Nombre:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(19, 14);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(56, 20);
            this.label4.TabIndex = 0;
            this.label4.Text = "Filtros";
            // 
            // companiesTab
            // 
            this.companiesTab.Location = new System.Drawing.Point(4, 22);
            this.companiesTab.Name = "companiesTab";
            this.companiesTab.Padding = new System.Windows.Forms.Padding(3);
            this.companiesTab.Size = new System.Drawing.Size(820, 471);
            this.companiesTab.TabIndex = 2;
            this.companiesTab.Text = "Empresas";
            this.companiesTab.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 16F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(134, 21);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(515, 31);
            this.label1.TabIndex = 1;
            this.label1.Text = "UniSell: Gestión de usuarios y compañías";
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = global::UniSell.NET.ConsoleClient.Properties.Resources.shopping_cart;
            this.pictureBox1.Location = new System.Drawing.Point(71, 12);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(57, 50);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 2;
            this.pictureBox1.TabStop = false;
            // 
            // HomeForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(852, 598);
            this.Controls.Add(this.pictureBox1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.Inicio);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "HomeForm";
            this.Text = "UniSell: Inicio";
            this.Inicio.ResumeLayout(false);
            this.homeTab.ResumeLayout(false);
            this.homeTab.PerformLayout();
            this.usersTab.ResumeLayout(false);
            this.usersTab.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TabControl Inicio;
        private System.Windows.Forms.TabPage homeTab;
        private System.Windows.Forms.TabPage usersTab;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.TabPage companiesTab;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox name_filter;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox surname_filter;
        private System.Windows.Forms.Label surname_label;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.TextBox email_filter;
        private System.Windows.Forms.TextBox username_filter;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.ComboBox document_type_filter;
        private System.Windows.Forms.TextBox document_filter;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.ComboBox rol_filter;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TableLayoutPanel userTable;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button newSellerButton;
        private System.Windows.Forms.Button newAdminButton;
    }
}