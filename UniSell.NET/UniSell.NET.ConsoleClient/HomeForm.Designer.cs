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
            this.label10 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.label13 = new System.Windows.Forms.Label();
            this.label14 = new System.Windows.Forms.Label();
            this.label15 = new System.Windows.Forms.Label();
            this.label16 = new System.Windows.Forms.Label();
            this.label17 = new System.Windows.Forms.Label();
            this.comp_name = new System.Windows.Forms.TextBox();
            this.comp_desc = new System.Windows.Forms.TextBox();
            this.comp_city = new System.Windows.Forms.TextBox();
            this.comp_region = new System.Windows.Forms.TextBox();
            this.comp_country = new System.Windows.Forms.TextBox();
            this.comp_zipcode = new System.Windows.Forms.TextBox();
            this.comp_document = new System.Windows.Forms.TextBox();
            this.comp_document_type = new System.Windows.Forms.ComboBox();
            this.filterCompanies = new System.Windows.Forms.Button();
            this.companiesTable = new System.Windows.Forms.TableLayoutPanel();
            this.newCompanyButton = new System.Windows.Forms.Button();
            this.Inicio.SuspendLayout();
            this.homeTab.SuspendLayout();
            this.usersTab.SuspendLayout();
            this.companiesTab.SuspendLayout();
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
            this.label4.Location = new System.Drawing.Point(19, 10);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(56, 20);
            this.label4.TabIndex = 0;
            this.label4.Text = "Filtros";
            // 
            // companiesTab
            // 
            this.companiesTab.Controls.Add(this.newCompanyButton);
            this.companiesTab.Controls.Add(this.companiesTable);
            this.companiesTab.Controls.Add(this.filterCompanies);
            this.companiesTab.Controls.Add(this.comp_document_type);
            this.companiesTab.Controls.Add(this.comp_document);
            this.companiesTab.Controls.Add(this.comp_zipcode);
            this.companiesTab.Controls.Add(this.comp_country);
            this.companiesTab.Controls.Add(this.comp_region);
            this.companiesTab.Controls.Add(this.comp_city);
            this.companiesTab.Controls.Add(this.comp_desc);
            this.companiesTab.Controls.Add(this.comp_name);
            this.companiesTab.Controls.Add(this.label17);
            this.companiesTab.Controls.Add(this.label16);
            this.companiesTab.Controls.Add(this.label15);
            this.companiesTab.Controls.Add(this.label14);
            this.companiesTab.Controls.Add(this.label13);
            this.companiesTab.Controls.Add(this.label12);
            this.companiesTab.Controls.Add(this.label11);
            this.companiesTab.Controls.Add(this.label10);
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
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label10.Location = new System.Drawing.Point(14, 9);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(56, 20);
            this.label10.TabIndex = 0;
            this.label10.Text = "Filtros";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(19, 36);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(55, 15);
            this.label11.TabIndex = 1;
            this.label11.Text = "Nombre:";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(341, 36);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(75, 15);
            this.label12.TabIndex = 2;
            this.label12.Text = "Descripción:";
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(19, 61);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(49, 15);
            this.label13.TabIndex = 3;
            this.label13.Text = "Ciudad:";
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.Location = new System.Drawing.Point(341, 61);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(50, 15);
            this.label14.TabIndex = 4;
            this.label14.Text = "Región:";
            // 
            // label15
            // 
            this.label15.AutoSize = true;
            this.label15.Location = new System.Drawing.Point(20, 92);
            this.label15.Name = "label15";
            this.label15.Size = new System.Drawing.Size(34, 15);
            this.label15.TabIndex = 5;
            this.label15.Text = "País:";
            // 
            // label16
            // 
            this.label16.AutoSize = true;
            this.label16.Location = new System.Drawing.Point(338, 92);
            this.label16.Name = "label16";
            this.label16.Size = new System.Drawing.Size(86, 15);
            this.label16.TabIndex = 6;
            this.label16.Text = "Código Postal:";
            // 
            // label17
            // 
            this.label17.AutoSize = true;
            this.label17.Location = new System.Drawing.Point(17, 118);
            this.label17.Name = "label17";
            this.label17.Size = new System.Drawing.Size(74, 15);
            this.label17.TabIndex = 7;
            this.label17.Text = "Documento:";
            // 
            // comp_name
            // 
            this.comp_name.Location = new System.Drawing.Point(97, 33);
            this.comp_name.Name = "comp_name";
            this.comp_name.Size = new System.Drawing.Size(222, 20);
            this.comp_name.TabIndex = 8;
            // 
            // comp_desc
            // 
            this.comp_desc.Location = new System.Drawing.Point(422, 32);
            this.comp_desc.Name = "comp_desc";
            this.comp_desc.Size = new System.Drawing.Size(343, 20);
            this.comp_desc.TabIndex = 9;
            // 
            // comp_city
            // 
            this.comp_city.Location = new System.Drawing.Point(97, 61);
            this.comp_city.Name = "comp_city";
            this.comp_city.Size = new System.Drawing.Size(222, 20);
            this.comp_city.TabIndex = 10;
            // 
            // comp_region
            // 
            this.comp_region.Location = new System.Drawing.Point(422, 59);
            this.comp_region.Name = "comp_region";
            this.comp_region.Size = new System.Drawing.Size(343, 20);
            this.comp_region.TabIndex = 11;
            // 
            // comp_country
            // 
            this.comp_country.Location = new System.Drawing.Point(98, 87);
            this.comp_country.Name = "comp_country";
            this.comp_country.Size = new System.Drawing.Size(222, 20);
            this.comp_country.TabIndex = 12;
            // 
            // comp_zipcode
            // 
            this.comp_zipcode.Location = new System.Drawing.Point(423, 87);
            this.comp_zipcode.Name = "comp_zipcode";
            this.comp_zipcode.Size = new System.Drawing.Size(343, 20);
            this.comp_zipcode.TabIndex = 13;
            // 
            // comp_document
            // 
            this.comp_document.Location = new System.Drawing.Point(98, 112);
            this.comp_document.Name = "comp_document";
            this.comp_document.Size = new System.Drawing.Size(219, 20);
            this.comp_document.TabIndex = 14;
            // 
            // comp_document_type
            // 
            this.comp_document_type.FormattingEnabled = true;
            this.comp_document_type.Location = new System.Drawing.Point(423, 112);
            this.comp_document_type.Name = "comp_document_type";
            this.comp_document_type.Size = new System.Drawing.Size(343, 21);
            this.comp_document_type.TabIndex = 15;
            // 
            // filterCompanies
            // 
            this.filterCompanies.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.filterCompanies.Location = new System.Drawing.Point(661, 139);
            this.filterCompanies.Name = "filterCompanies";
            this.filterCompanies.Size = new System.Drawing.Size(104, 35);
            this.filterCompanies.TabIndex = 16;
            this.filterCompanies.Text = "Filtrar";
            this.filterCompanies.UseVisualStyleBackColor = true;
            this.filterCompanies.Click += new System.EventHandler(this.filterCompanies_Click);
            // 
            // companiesTable
            // 
            this.companiesTable.ColumnCount = 9;
            this.companiesTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.companiesTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.companiesTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.companiesTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.companiesTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.companiesTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.companiesTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.companiesTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.companiesTable.ColumnStyles.Add(new System.Windows.Forms.ColumnStyle(System.Windows.Forms.SizeType.Percent, 11.11111F));
            this.companiesTable.Location = new System.Drawing.Point(23, 183);
            this.companiesTable.Name = "companiesTable";
            this.companiesTable.RowCount = 1;
            this.companiesTable.RowStyles.Add(new System.Windows.Forms.RowStyle());
            this.companiesTable.Size = new System.Drawing.Size(743, 231);
            this.companiesTable.TabIndex = 17;
            // 
            // newCompanyButton
            // 
            this.newCompanyButton.BackColor = System.Drawing.Color.LightGreen;
            this.newCompanyButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.newCompanyButton.Location = new System.Drawing.Point(23, 420);
            this.newCompanyButton.Name = "newCompanyButton";
            this.newCompanyButton.Size = new System.Drawing.Size(143, 45);
            this.newCompanyButton.TabIndex = 0;
            this.newCompanyButton.Text = "Nueva empresa";
            this.newCompanyButton.UseVisualStyleBackColor = false;
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
            this.companiesTab.ResumeLayout(false);
            this.companiesTab.PerformLayout();
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
        private System.Windows.Forms.ComboBox comp_document_type;
        private System.Windows.Forms.TextBox comp_document;
        private System.Windows.Forms.TextBox comp_zipcode;
        private System.Windows.Forms.TextBox comp_country;
        private System.Windows.Forms.TextBox comp_region;
        private System.Windows.Forms.TextBox comp_city;
        private System.Windows.Forms.TextBox comp_desc;
        private System.Windows.Forms.TextBox comp_name;
        private System.Windows.Forms.Label label17;
        private System.Windows.Forms.Label label16;
        private System.Windows.Forms.Label label15;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Button filterCompanies;
        private System.Windows.Forms.TableLayoutPanel companiesTable;
        private System.Windows.Forms.Button newCompanyButton;
    }
}