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
- `OBJECT 1`<br>
{<br>
  "firstName":" Julius",<br>
  "lastName": "Gordon",<br>
  "cpf":"498.244.920-11",<br>
  "birthday":"25-12-1999",<br>
  "phones": [<br>
  	{<br>
      "type":"MOBILE",<br>
      "number":"1234567890"<br>
    },<br>
    {<br>
      "type":"COMMERCIAL",<br>
      "number":"+12 21 6789 0123"<br>
    },<br>
    {<br>
        "type": "HOME",<br>
        "number": "+55 68 99789 0123"<br>
    }<br>
  ]<br>
}<br>
<br>
- `OBJECT 2`<br>
{<br>
  "firstName":"Potato",<br>
  "lastName": "Head",<br>
  "cpf":"022.196.280-86",<br>
  "birthday":"28-09-1925",<br>
  "phones": [<br>
  	{<br>
      "type":"MOBILE",<br>
      "number":"+12 61 6789 0123"<br>
    },<br>
    {<br>
      "type":"COMMERCIAL",<br>
      "number":"+00 08 98912 4567"<br>
    },<br>
    {<br>
        "type": "HOME",<br>
        "number": "+1234 54321-1234"<br>
    }<br>
  ]<br>
} <br>

## :hammer: Features and structure
This API allows the follow operations in person objects, using Rest communication pattern:
- `Create person`: using  the <b>POST</b> http verb to send a person object to API;
- `Read person`: using the <b>GET</b> http verb to send a request to API;
- `Read all`: using the <b>GET</b> http verb to send a request to API;
- `Update person`: using the <b>PUT</b> http verb to send a person object to API;
- `Delete person`: using the <b>DELETE</b> http verb to send a request to API;

## :key: Acess
This API can be acessed by the follow mainly link:
<a target="blank" href="https://people-api-java-github.herokuapp.com/api/v1/person">
https://people-api-java-github.herokuapp.com/api/v1/person.
</a><br>
The available operations can be performed as below:<br>
- `Create person`: send a valid person object using <b>POST</b>, to mainly link;
- `Read person`: send a empty request using <b>GET</b>, and add the <b>person ID</b> in the end of mainly link. The ID field is generated automatically when a person is created.  Example: https://people-api-java-github.herokuapp.com/api/v1/person/1, return a person with ID 1;
- `Read all`: send a empty request using <b>GET</b> to mainly link;
- `Update person`: send a valid person object using <b>PUT</b>, and add the <b>ID</b> of person that will be updated, in the end of mainly link ;
- `Delete person`: send a empty request using <b>DELETE</b>, and add the <b>ID</b> of person that will be deleted, in the end of mainly link.