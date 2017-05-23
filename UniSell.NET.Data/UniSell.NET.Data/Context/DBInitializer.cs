using System.Data.Entity;

namespace UniSell.NET.Data.Context
{
    public class DBInitializer : DropCreateDatabaseAlways<DBContext>
    {
        protected override void Seed(DBContext context)
        {
            base.Seed(context);
        }
    }
}