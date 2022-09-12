using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TheExamAPC
{
    public abstract class Product
    {
        public int ID;
        public string Name;
        public double Price;

        protected Product(int id, string name, double price)
        {
            ID = id;
            Name = name;
            Price = price;
        }

        public abstract double computeTax();
    }
}
