package com.example.masove;

public class UserS {
        private String name;
        private String Id;
        private String Email;

        public UserS() {
        }

        public UserS(String name, String uId, String uEmail) {
                this.name = name;
                this.Id = uId;
                this.Email = uEmail;
        }



        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getId() {
                return Id;
        }

        public void setId(String id) {
                this.Id = id;
        }

        public String getUEmail() {
                return Email;
        }

        public void setUEmail(String UEmail) {
                this.Email = UEmail;
        }

        }
