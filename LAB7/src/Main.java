import mvc.*;
import mvp.*;
import mvvm.*;
public class Main {
    public static void main(String[] args) {

        System.out.println("MVC MODEL WEAPON STORE: ");

        WeaponStoreMVC.WeaponStoreModel weaponModel =
                new WeaponStoreMVC.WeaponStoreModel();
        WeaponStoreMVC.WeaponStoreView weaponView =
                new WeaponStoreMVC.WeaponStoreView();
        WeaponStoreMVC.WeaponStoreController weaponController =
                new WeaponStoreMVC.WeaponStoreController(weaponModel, weaponView);

        weaponController.add("AK-308", 64);
        weaponController.add("CG NL545", 53);
        weaponController.remove("AK-308");

        System.out.println("\nMVC MODEL END\n");
        System.out.println("MVP MODEL USER PROFILE:");

        UserProfileMVP.UserProfile userModel =
                new UserProfileMVP.UserProfile("Petr", "petya@gmail.com", 20);

        UserProfileMVP.UserProfileView userView =
                new UserProfileMVP.ConsoleUserProfileView();

        UserProfileMVP.UserProfilePresenter presenter =
                new UserProfileMVP.UserProfilePresenter(userView, userModel);

        presenter.showProfile();
        presenter.updateName("Elizabeth");
        presenter.updateEmail("elizabeth21@gmail.com");
        presenter.updateAge(21);

        System.out.println("\nMVP MODEL END\n");
        System.out.println("MVVM MODEL TASK TIME:");

        TaskTimeMVVM.TaskListViewModel listVm = new TaskTimeMVVM.TaskListViewModel();
        TaskTimeMVVM.ConsoleView view = new TaskTimeMVVM.ConsoleView();

        TaskTimeMVVM.TaskViewModel t1 = listVm.addTask("Write report", 30);
        TaskTimeMVVM.TaskViewModel t2 = listVm.addTask("Fix bugs", 20);

        view.render(listVm);

        t1.spend(10); view.render(listVm);
        t2.spend(5);  view.render(listVm);
        t1.spend(10); view.render(listVm);
        t2.spend(10); view.render(listVm);
        t1.spend(15); view.render(listVm);
    }
}