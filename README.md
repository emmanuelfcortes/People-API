<h1> Simple API to manager people</h1><br.>

## :books: Description

This API is a CRUD-API, that implements the funcionality of create, read, update and delete people.

## :gem: Structure of person object
The person object has the follow attributes:
- `firstName`: a String field ;
- `lastName`: a String field;
- `birthday`: a String field, that accept a string in the format "dd-mm-yyyy", where "dd" is the day with 2 numbers, "mm" represents the month, with 2 numbers too, and "yyyy" represents the year with 4 numbers.
- `cpf`: a String field, that recept a CPF (a document from Brazil, formed by a unique numerical sequence of 11 numbers, tha have to follow an especific pattern);
- `phones`: a list of telephone type objects. Each telephone object has two attributes: "type", that can assume the values "MOBILE", "HOME", or "COMMERCIAL"; and "number", a numeric field that maximum size is 10. The "number" accept numbers with country code (1 to 3 numbers) and state code (2 or 3 numbers).
## :loop: Examples
These are two person objects examples, in JSON format:
- `OBJECT 1`
{
  "firstName":" Julius",
  "lastName": "Gordon",
  "cpf":"498.244.920-11",
  "birthday":"25-12-1999",
  "phones": [
  	{
      "type":"MOBILE",
      "number":"1234567890"
    },
    {
      "type":"COMMERCIAL",
      "number":"+12 21 6789 0123"
    },
    {
        "type": "HOME",
        "number": "+55 68 99789 0123"
    }
  ]
}
- `OBJECT 2`
{
  "firstName":"Potato",
  "lastName": "Head",
  "cpf":"022.196.280-86",
  "birthday":"28-09-1925",
  "phones": [
  	{
      "type":"MOBILE",
      "number":"+12 61 6789 0123"
    },
    {
      "type":"COMMERCIAL",
      "number":"+00 08 98912 4567"
    },
    {
        "type": "HOME",
        "number": "+1234 54321-1234"
    }
  ]
} 

## :hammer: Features and structure
This API allows the follow operations in person objects, using Rest communication pattern:
- `Create person`: using  the POST verb to send a person object to API;
- `Read person`: using the GET verb to send a request to API;
- `Read all`: using the GET verb to send a request to API;
- `Update person`: using the PUT verb to send a person object to API;
- `Delete person`: using the DELETE verb to send a request to API;

## :hammer: Acess