/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTestApp;

/**
 *
 * @author staff
 */
public class LabUser 
{
        private String firstName;
        private String lastName;
        private String userGender;
        private String dateofBirth;
        private String emailID;
        private String userPassword;
        private int privilege;
        
        public LabUser()
        {
            this.firstName="";
            this.lastName="";
            this.userGender="";
            this.dateofBirth="";
            this.emailID="";
            this.userPassword="";
            this.privilege=3;
        }
        
        //Setters
        public void setFirstName(String fname)
        {
            this.firstName=fname;
        }
        public void setLastName(String lname)
        {
            this.lastName=lname;
        }
        public void setUserGender(String gender)
        {
            this.userGender=gender;
        }
        public void setDateOfBirth(String dob)
        {
            this.dateofBirth=dob;
        }
        public void setEmailID(String email)
        {
            this.emailID=email;
        }
        public void setPassword(String password)
        {
            this.userPassword=password;
        }
        
        public void setPrivilege(int privilege) 
        {
            this.privilege=privilege;
        }
        
        //Getters
        public String firstName()
        {
            return this.firstName;
        }
        public String lastName()
        {
            return this.lastName;
        }
        public String userGender()
        {
            return this.userGender;
        }
        public String dateOfBirth()
        {
            return this.dateofBirth;
        }
        public String emailID()
        {
            return this.emailID;
        }
        public String password()
        {
            return this.userPassword;
        }
        
        public int privilege() 
        {
            return this.privilege;
        }
        
}
