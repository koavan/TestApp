/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function emailValidate( e )
{
    var text;
    var mail=e.toString();
    if(mail=="")
    {
        text = "Email cannot be left blank";
    }
    else if (! /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail))
    {
        text = "Enter a valid Email address!";
    }
    else
    {
        text="";
    }
    document.getElementById("alert-email").innerHTML = text;
}

function fnameValidate()
{    
    var text;
    var fname=document.forms["signup-form"]["first-name"].value;
    if(fname==="")
    {
        text = "First name cannot be left blank";

    }
    else
    {
        text = "";
    }
    document.getElementById("alert-fname").innerHTML = text;
}

function lnameValidate()
{
    var text;
    var lname=document.forms["signup-form"]["last-name"].value;
    if(lname==="")
    {
        text = "Last name cannot be left blank";
    }
    else
    {
        text = "";
    }
    document.getElementById("alert-lname").innerHTML = text;
}

function genderValidate()
{
    var text;
    var gender=document.forms["signup-form"]["gender"].value;
    if(gender==="")
    {
        text = "Gender name cannot be left blank";
    }
    else
    {
        text = "";
    }
    document.getElementById("alert-gender").innerHTML = text;
}

function dobValidate()
{
    window.genderValidate();
    var text;
    var dob=document.forms["signup-form"]["dob"].value;
    if(dob==="")
    {
        text = "Date Of Birth cannot be left blank";
    }
    else
    {
        text = "";
    }
    document.getElementById("alert-dob").innerHTML = text;
}

function fpswdValidate()
{
    var text;
    var fpasswd=document.forms["signup-form"]["first-password"].value;
    if(fpasswd==="")
    {
        text = "Password cannot be left blank";
    }
    else
    {
        text = "";
    }
    document.getElementById("alert-fpswd").innerHTML = text;
    window.cpswdValidate();
}

function spswdValidate()
{
    var text;
    var cpasswd=document.forms["signup-form"]["confirm-password"].value;
    var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
    if(cpasswd==="")
    {
        text = "Password cannot be left blank";
    }
    else if(!re.test(cpasswd))
    {
        text = "Password must contain at least one number, one lowercase and one uppercase letter and at least six characters";
    }
    else
    {
        text = "";
    }
    document.getElementById("alert-cpswd").innerHTML = text;
    window.cpswdValidate();
}

function cpswdValidate()
{
    var text;
    var fpasswd=document.forms["signup-form"]["first-password"].value;
    var cpasswd=document.forms["signup-form"]["confirm-password"].value;
    if(fpasswd !== cpasswd)
    {
        text = "Passwords must be same";
    }
    else
    {
        text = "";
    }
    document.getElementById("alert-cpswd").innerHTML = text;
}