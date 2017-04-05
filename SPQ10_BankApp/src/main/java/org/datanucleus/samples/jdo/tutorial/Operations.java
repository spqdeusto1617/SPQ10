/**********************************************************************
Copyright (c) 2003 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
    ...
**********************************************************************/
package main.java.org.datanucleus.samples.jdo.tutorial;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;

/**
 * Definition of a Book. Extends basic Product class.
 * @author      Diego Lopez-de-Ipina 
 * @version     1.0                                    
 * @since       2012-02-01        
 */
@PersistenceCapable
@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)
public class Operations extends Account
{
	/**
	 * This variable represents the name of a book author
	 */
    protected String author=null;

	/**
	 * This variable represents the name of the publisher of a book
	 */
  
    protected Operations()
    {
        super();
    }

	/**
	 * Parametized constructor of book receiving as parameters:
	 * @param name String corresponding to the title of the book 
	 * @param description String corresponding to the name of the book author
	 * @param price double corresponding to the price of the book
	 * @param author String corresponding to the name of the book author
	 * @param isbn String corresponding to the ISBN of the book
	 * @param publisher String corresponding to the name of the book publisher
	*/
    public Operations(String name, String description, String author)
    {
        super(name,description,price);
        this.author = author;

    }

	/**
	 * Getter for the name of the auhor
	 * @return The String corresponding to the name of the author
	 */
    public String getAuthor()
    {
        return author;
    }

	/**
	 * Setter for the book author
	 * @param author The String corresponding to the book author
	 */
    public void setAuthor(String author)
    {
        this.author = author;
    }

	/**
	 * String representation of a Book object instance
	 * @return The String corresponding to the string representation of a Book instance
	 */
    public String toString()
    {
        return "Book : " + author + " - " + name;
    }
}