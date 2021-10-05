package Utils;

import DAOs.*;
import Models.Customer;
import Models.UserInfo;
import MyCollections.MyArrayList;

import java.sql.SQLException;

public class CredentialChecker {
    public static CredentialChecker credentialChecker;

        public static CredentialChecker getManager()
        {
            if (credentialChecker == null)
            {
                credentialChecker = new CredentialChecker();
            }

            return credentialChecker;
        }

        /**
         * Checks DB to see if username and password match each other under the same Customer Account
         * @param username
         * @param password
         * @return
         */
        public boolean verifyUser(String username, String password) {
                UserDAO userDAO = new UserDAO(ConnectionManager.conn);
                MyArrayList<UserInfo> users = new MyArrayList<>();
                boolean verified = false;

                try
                {
                    users = userDAO.getAll();
                } catch (SQLException e) {
                    System.out.println("Table is not properly formatted or is invalid. Can not fetch data.");
                }

                for (int i = 0; i < users.length(); i++){
                    if(users.get(i).getUSERNAME() == username && users.get(i).getPASSWORD() == password){
                        verified = true;
                        break;
                    }
                }

                return verified;
            }

            /**
             * This method verifies the syntax of the new account information given, before allowing account creation
             * @param username
             * @param password
             * @return
             */
            public boolean isValid(String username, String password){
                boolean userValid = false, passValid = false, createValid = false;
                char[] usernameElements = username.toCharArray();
                char[] passwordElements = password.toCharArray();

                for (Character c: usernameElements)
                {
                    if (Character.isLetterOrDigit(c))
                    {
                        userValid = true;
                    }
                }

                for (Character c : passwordElements)
                {
                    if (Character.isLetterOrDigit(c))
                    {
                        passValid = true;
                    }
                }

                if (userValid && passValid)
                {
                    createValid = true;
                }

                return  createValid;
            }
    }

