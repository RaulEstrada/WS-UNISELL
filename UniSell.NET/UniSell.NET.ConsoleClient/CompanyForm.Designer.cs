namespace UniSell.NET.ConsoleClient
{
    partial class CompanyForm
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(CompanyForm));
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.com_name = new System.Windows.Forms.TextBox();
            this.com_desc = new System.Windows.Forms.TextBox();
            this.com_doc = new System.Windows.Forms.TextBox();
            this.com_city = new System.Windows.Forms.TextBox();
            this.com_region = new System.Windows.Forms.TextBox();
            this.com_country = new System.Windows.Forms.TextBox();
            this.com_zipcode = new System.Windows.Forms.TextBox();
            this.com_doc_type = new System.Windows.Forms.ComboBox();
            this.save_company_button = new System.Windows.Forms.Button();
            this.edit_company_button = new System.Windows.Forms.Button();
            this.clear_company_button = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(29, 25);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(171, 25);
            this.label1.TabIndex = 0;
            this.label1.Text = "Datos de empresa";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(34, 73);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(55, 15);
            this.label2.TabIndex = 1;
            this.label2.Text = "Nombre:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(367, 73);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(75, 15);
            this.label3.TabIndex = 2;
            this.label3.Text = "Descripción:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(34, 114);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(74, 15);
            this.label4.TabIndex = 3;
            this.label4.Text = "Documento:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(34, 157);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(49, 15);
            this.label5.TabIndex = 4;
            this.label5.Text = "Ciudad:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(367, 157);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(50, 15);
            this.label6.TabIndex = 5;
            this.label6.Text = "Región:";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(34, 207);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(34, 15);
            this.label7.TabIndex = 6;
            this.label7.Text = "País:";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(367, 207);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(86, 15);
            this.label8.TabIndex = 7;
            this.label8.Text = "Código Postal:";
            // 
            // com_name
            // 
            this.com_name.Location = new System.Drawing.Point(149, 69);
            this.com_name.Name = "com_name";
            this.com_name.Size = new System.Drawing.Size(164, 20);
            this.com_name.TabIndex = 8;
            this.com_name.Tag = "nombre";
            // 
            // com_desc
            // 
            this.com_desc.Location = new System.Drawing.Point(465, 68);
            this.com_desc.Name = "com_desc";
            this.com_desc.Size = new System.Drawing.Size(212, 20);
            this.com_desc.TabIndex = 9;
            this.com_desc.Tag = "descripción";
            // 
            // com_doc
            // 
            this.com_doc.Location = new System.Drawing.Point(149, 109);
            this.com_doc.Name = "com_doc";
            this.com_doc.Size = new System.Drawing.Size(164, 20);
            this.com_doc.TabIndex = 10;
            this.com_doc.Tag = "documento";
            // 
            // com_city
            // 
            this.com_city.Location = new System.Drawing.Point(149, 152);
            this.com_city.Name = "com_city";
            this.com_city.Size = new System.Drawing.Size(164, 20);
            this.com_city.TabIndex = 11;
            this.com_city.Tag = "ciudad";
            // 
            // com_region
            // 
            this.com_region.Location = new System.Drawing.Point(465, 152);
            this.com_region.Name = "com_region";
            this.com_region.Size = new System.Drawing.Size(212, 20);
            this.com_region.TabIndex = 12;
            this.com_region.Tag = "región";
            // 
            // com_country
            // 
            this.com_country.Location = new System.Drawing.Point(149, 202);
            this.com_country.Name = "com_country";
            this.com_country.Size = new System.Drawing.Size(164, 20);
            this.com_country.TabIndex = 13;
            this.com_country.Tag = "país";
            // 
            // com_zipcode
            // 
            this.com_zipcode.Location = new System.Drawing.Point(465, 204);
            this.com_zipcode.Name = "com_zipcode";
            this.com_zipcode.Size = new System.Drawing.Size(212, 20);
            this.com_zipcode.TabIndex = 14;
            this.com_zipcode.Tag = "código postal";
            // 
            // com_doc_type
            // 
            this.com_doc_type.FormattingEnabled = true;
            this.com_doc_type.Location = new System.Drawing.Point(465, 108);
            this.com_doc_type.Name = "com_doc_type";
            this.com_doc_type.Size = new System.Drawing.Size(212, 21);
            this.com_doc_type.TabIndex = 15;
            this.com_doc_type.Tag = "tipo de documento";
            // 
            // save_company_button
            // 
            this.save_company_button.BackColor = System.Drawing.Color.LightGreen;
            this.save_company_button.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.save_company_button.Location = new System.Drawing.Point(525, 255);
            this.save_company_button.Name = "save_company_button";
            this.save_company_button.Size = new System.Drawing.Size(152, 46);
            this.save_company_button.TabIndex = 16;
            this.save_company_button.Text = "Guardar";
            this.save_company_button.UseVisualStyleBackColor = false;
            this.save_company_button.Click += new System.EventHandler(this.save_company_button_Click);
            // 
            // edit_company_button
            // 
            this.edit_company_button.BackColor = System.Drawing.Color.LightGreen;
            this.edit_company_button.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.edit_company_button.Location = new System.Drawing.Point(525, 255);
            this.edit_company_button.Name = "edit_company_button";
            this.edit_company_button.Size = new System.Drawing.Size(152, 46);
            this.edit_company_button.TabIndex = 17;
            this.edit_company_button.Text = "Guardar";
            this.edit_company_button.UseVisualStyleBackColor = false;
            this.edit_company_button.Click += new System.EventHandler(this.edit_company_button_Click);
            // 
            // clear_company_button
            // 
            this.clear_company_button.BackColor = System.Drawing.Color.LightSalmon;
            this.clear_company_button.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.clear_company_button.Location = new System.Drawing.Point(384, 255);
            this.clear_company_button.Name = "clear_company_button";
            this.clear_company_button.Size = new System.Drawing.Size(124, 46);
            this.clear_company_button.TabIndex = 18;
            this.clear_company_button.Text = "Limpiar";
            this.clear_company_button.UseVisualStyleBackColor = false;
            this.clear_company_button.Click += new System.EventHandler(this.clear_company_button_Click);
            // 
            // CompanyForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(724, 338);
            this.Controls.Add(this.clear_company_button);
            this.Controls.Add(this.edit_company_button);
            this.Controls.Add(this.save_company_button);
            this.Controls.Add(this.com_doc_type);
            this.Controls.Add(this.com_zipcode);
            this.Controls.Add(this.com_country);
            this.Controls.Add(this.com_region);
            this.Controls.Add(this.com_city);
            this.Controls.Add(this.com_doc);
            this.Controls.Add(this.com_desc);
            this.Controls.Add(this.com_name);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "CompanyForm";
            this.Text = "UniSell: Datos de empresa";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.TextBox com_name;
        private System.Windows.Forms.TextBox com_desc;
        private System.Windows.Forms.TextBox com_doc;
        private System.Windows.Forms.TextBox com_city;
        private System.Windows.Forms.TextBox com_region;
        private System.Windows.Forms.TextBox com_country;
        private System.Windows.Forms.TextBox com_zipcode;
        private System.Windows.Forms.ComboBox com_doc_type;
        private System.Windows.Forms.Button save_company_button;
        private System.Windows.Forms.Button edit_company_button;
        private System.Windows.Forms.Button clear_company_button;
    }
}