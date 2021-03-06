﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UniSell.NET.Data.Model;

namespace UniSell.NET.Data.Persistence
{
    public interface ICategoryDAO : IGenericDAO<Category>
    {
        Category[] FindByName(string name = null);
    }
}
