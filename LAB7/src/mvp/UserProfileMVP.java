package mvp;

public class UserProfileMVP {

    //model vegin
    public static class UserProfile {
        private String name;
        private String email;
        private int age;

        public UserProfile(String name, String email, int age) {
            this.name = name;
            this.email = email;
            this.age = age;
        }

        public String getName() { return name; }
        public String getEmail() { return email; }
        public int getAge() { return age; }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    //view begin
    public interface UserProfileView {
        void renderProfile(String name, String email, int age);
        void showMessage(String message);
    }

    public static class ConsoleUserProfileView implements UserProfileView {

        @Override
        public void renderProfile(String name, String email, int age) {
            System.out.println("\nUSER PRROFILE DATA");
            System.out.println("Name : " + name);
            System.out.println("Email: " + email);
            System.out.println("Age  : " + age);
        }

        @Override
        public void showMessage(String message) {
            System.out.println(message);
        }
    }

    //presenter begin
    public static class UserProfilePresenter {
        private final UserProfileView view;
        private final UserProfile model;

        public UserProfilePresenter(UserProfileView view, UserProfile model) {
            this.view = view;
            this.model = model;
        }

        public void showProfile() {
            view.renderProfile(model.getName(), model.getEmail(), model.getAge());
        }

        public void updateName(String name) {
            model.setName(name);
            view.showMessage("Name updated");
            showProfile();
        }

        public void updateEmail(String email) {
            model.setEmail(email);
            view.showMessage("Email updated");
            showProfile();
        }

        public void updateAge(int age) {
            model.setAge(age);
            view.showMessage("Age updated");
            showProfile();
        }
    }
}