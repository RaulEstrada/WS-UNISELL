using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using UniSell.NET.Data.Context;

namespace UniSell.NET.Data.Persistence.Implementation
{
    public class GenericDAO<T> : IGenericDAO<T> where T : class
    {
        private DBContext Context { get; set; }

        public GenericDAO(DBContext context)
        {
            this.Context = context;
        }

        protected DbSet<T> DbSet
        {
            get { return Context.Set<T>(); }
        }

        public IEnumerable<T> All()
        {
            return DbSet.ToList();
        }

        public int Count()
        {
            return DbSet.Count();
        }

        public T Create(T t)
        {
            DbSet.Add(t);
            return Context.SaveChanges() != 0 ? t : null;
        }

        public T Find(long id)
        {
            return DbSet.Find(id);
        }

        public T Remove(long id)
        {
            T target = Find(id);
            DbSet.Remove(target);
            return Context.SaveChanges() != 0 ? target : null;
        }

        public T Update(T t)
        {
            DbSet.Attach(t);
            Context.Entry(t).State = EntityState.Modified;
            return Context.SaveChanges() != 0 ? t : null;
        }
    }
}