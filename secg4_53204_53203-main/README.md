# SECG4_53204_53203

Zedzian Pawel 53204 - Anas Ben Allal 53203 


To run the app you need to install XAMPP
You need to put the folder of your project on (mine is in C:\xampp\htdocs)


Create the database : thanks to xampp you can create a data base for this project to work you need to call your data base:
`secg4`


when you have created your database in your project folder open your terminal and type 

```-php artisan serve```   (if the php command don't work you need to add it to your path) 

and go to the given link (mine http://127.0.0.1:8000/ )


you can populate your database users with the sql file i gave you 

on this page you can login->existing user or register->create new user

```php artisan storage:link``` for display and make a link with laravel and folder 
```composer require brainstud/file-vault```for add library of FileVault

For be sur : if the project don't work because of laravel (the .env file is automaticly remove after new location), just creat un new project laravel with ```composer create-project laravel/laravel nameProject``` and juste copy/past or move folder and file
app/Http/Controller
app/View
public/css
public/img
routes/auth
routes/web.php
routes/auth.php
resources/views

to your new laravel project,
and also create your database with xampp http://localhost/phpmyadmin , use the sql file for create and populate your new database.

one user you can use is :
email: Admin@admin.admin
password: Admin53204
