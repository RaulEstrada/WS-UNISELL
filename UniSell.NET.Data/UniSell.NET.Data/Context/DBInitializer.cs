using System.Data.Entity;

namespace UniSell.NET.Data.Context
{
    public class DBInitializer : DropCreateDatabaseIfModelChanges<DBContext>
    {
        protected override void Seed(DBContext context)
        {
            base.Seed(context);
        }
    }
}