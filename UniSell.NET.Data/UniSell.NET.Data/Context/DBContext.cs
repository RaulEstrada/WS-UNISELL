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
    }
}