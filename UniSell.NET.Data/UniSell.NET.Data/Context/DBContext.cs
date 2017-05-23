using MySql.Data.Entity;
using MySql.Data.MySqlClient;
using System.Configuration;
using System.Data.Entity;
using System.Web.Configuration;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.Context
{
    [DbConfigurationType(typeof(MySqlEFConfiguration))]
    public class DBContext : DbContext
    {
        public DBContext() : base(new MySqlConnection(WebConfigurationManager.AppSettings["connectionString"]), false)
        {
            Database.SetInitializer(new DBInitializer());
        }

        public DbSet<User> User { get; set; }
        public DbSet<UserAdmin> UserAdmin { get; set; }
        public DbSet<UserSeller> UserSeller { get; set; }
        public DbSet<UserBuyer> UserBuyer { get; set; }
        public DbSet<Company> Company { get; set; }

    }
}