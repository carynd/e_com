# e_com(updated code in shopping_cart branch)
Spring Boot Backend Application for an e-commerce website which has a MySql database.


## Overview
Backend for an e-commerce website which has a MySql database.

## Technologies Used
* Java 
* Spring Boot
* Swagger
* REST API
* MySql Database.


## Features
* Users can register to our system, and sign in to it.
* Can create a new category and update it
* Add products belonging to a category and update it.
* Add items to user's Wishlist,remove items as well.
* Get details of user's wishlist items.
* Add items to user's cart.
* Delete items from user's cart
* View items of user's cart.


## REST API Contracts
METHOD | ROUTE | DESCRIPTION 
------------|-----|------------
POST | /user/signin | Signing in using email and password.
POST | /user/signup | SignUp for new user.
POST | /category/create | Creating a category for product.
GET | /category/list | List of all categories.
POST | /category/update/{categoryId} | To update an existing category.
POST | /product/add | Add new product.
GET | /product/list | Get a list of all products.
POST | /product/update/{productId} | Update a product.
GET | /wishlist/{token} | Get list of wishlist items of a user.
POST | /wishlist/add/product/{productId} | Adding a product to user's wishlist.
GET | /cart/{token} | Get user's cart items.
POST | /cart/add | Adding an item into user's cart.
DELETE | /cart/delete/{cartItemId} | Removing/deleting an item from user's cart.


## Developed by
* Caryn Dsouza(me)
