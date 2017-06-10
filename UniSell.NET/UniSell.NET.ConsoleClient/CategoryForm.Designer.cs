namespace UniSell.NET.ConsoleClient
{
    partial class CategoryForm
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(CategoryForm));
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.category_name = new System.Windows.Forms.TextBox();
            this.saveCategoryBtn = new System.Windows.Forms.Button();
            this.editCategoryBtn = new System.Windows.Forms.Button();
            this.clearCategory = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Underline, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(26, 32);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(175, 25);
            this.label1.TabIndex = 0;
            this.label1.Text = "Datos de categoría";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(31, 82);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(55, 15);
            this.label2.TabIndex = 1;
            this.label2.Text = "Nombre:";
            // 
            // category_name
            // 
            this.category_name.Location = new System.Drawing.Point(106, 82);
            this.category_name.Name = "category_name";
            this.category_name.Size = new System.Drawing.Size(278, 20);
            this.category_name.TabIndex = 2;
            // 
            // saveCategoryBtn
            // 
            this.saveCategoryBtn.BackColor = System.Drawing.Color.PaleGreen;
            this.saveCategoryBtn.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.saveCategoryBtn.Location = new System.Drawing.Point(273, 130);
            this.saveCategoryBtn.Name = "saveCategoryBtn";
            this.saveCategoryBtn.Size = new System.Drawing.Size(111, 38);
            this.saveCategoryBtn.TabIndex = 3;
            this.saveCategoryBtn.Text = "Guardar";
            this.saveCategoryBtn.UseVisualStyleBackColor = false;
            this.saveCategoryBtn.Click += new System.EventHandler(this.saveCategoryBtn_Click);
            // 
            // editCategoryBtn
            // 
            this.editCategoryBtn.BackColor = System.Drawing.Color.PaleGreen;
            this.editCategoryBtn.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.editCategoryBtn.Location = new System.Drawing.Point(273, 130);
            this.editCategoryBtn.Name = "editCategoryBtn";
            this.editCategoryBtn.Size = new System.Drawing.Size(111, 38);
            this.editCategoryBtn.TabIndex = 4;
            this.editCategoryBtn.Text = "Guardar";
            this.editCategoryBtn.UseVisualStyleBackColor = false;
            this.editCategoryBtn.Click += new System.EventHandler(this.editCategoryBtn_Click);
            // 
            // clearCategory
            // 
            this.clearCategory.BackColor = System.Drawing.Color.LightSalmon;
            this.clearCategory.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.clearCategory.Location = new System.Drawing.Point(170, 130);
            this.clearCategory.Name = "clearCategory";
            this.clearCategory.Size = new System.Drawing.Size(88, 38);
            this.clearCategory.TabIndex = 5;
            this.clearCategory.Text = "Limpiar";
            this.clearCategory.UseVisualStyleBackColor = false;
            this.clearCategory.Click += new System.EventHandler(this.clearCategory_Click);
            // 
            // CategoryForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(422, 195);
            this.Controls.Add(this.clearCategory);
            this.Controls.Add(this.editCategoryBtn);
            this.Controls.Add(this.saveCategoryBtn);
            this.Controls.Add(this.category_name);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "CategoryForm";
            this.Text = "UniSell: Datos de categoría";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox category_name;
        private System.Windows.Forms.Button saveCategoryBtn;
        private System.Windows.Forms.Button editCategoryBtn;
        private System.Windows.Forms.Button clearCategory;
    }
}