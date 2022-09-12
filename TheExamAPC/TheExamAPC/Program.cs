using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TheExamAPC
{
    class Program
    {
        static void Main(string[] args)
        {
            Product[] products = new Product[5];
            products[0] = new Book(1, "Notebook", 6000);
            products[1] = new Book(2, "Textbook", 32000);
            products[2] = new Book(3, "Comic", 28000);
            products[3] = new Phone(4, "Samsung Z Flip 5", 23000000);
            products[4] = new Phone(5, "Iphone 14 Pro Max", 32500000);

            double booktax = products[0].computeTax() + products[1].computeTax() + products[2].computeTax();
            Console.WriteLine("Tax of Book: " + booktax);

            double phonetax = products[3].computeTax() + products[4].computeTax();
            Console.WriteLine("Tax of Phone: " + phonetax);
        }
    }
}
