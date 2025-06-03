                                                     !!! Shree Swami Samarth !!!

*** Spring Security with JWT Token Authentication ***

1) Spring security -
   i) spring secuirty we have to secure our spring boot application.
   ii) It has two main concepts that is authentication and authorization.

2) Authentication
   Authentication means verify user identity.

3) Authorization
   Authorization means what access we are providing to authenticated user based on their role.

4) JWT Token authentication
   JWT token authentication we have to secure our rest api or end points.
   only authorized person will have access of those endpoints.

5) JWT Token
   i) JWT stands for Java web token
   ii) It made up of three parts.
   iii) header , payload and signture.

   A) header - header will show the algorithm used to make the token or what type of token it is.

   B) payload - payload will contain actual data or information like id , name etc.

   C) singture - like seal or stamp.

 6) Here is architecture of flow of http request using JWT Token

   Authentication - User will hit the login request, 
  AuthenticationManager will call to the userDetailsService.
  from userDetailsService it will fetch the encrypted passowrd and it will try to compare
  the received password in the request and the password fetched from db are eqaul or not.
  If both are not matched then will response to user as "User Not Found"

  If matched then will provide JWT token to that user.
  JWTS responsbile to generate the token , we can set the time period for that token validity.

  Next time the user will use that token and use the endpoints.
  

  
   
      
      

   
