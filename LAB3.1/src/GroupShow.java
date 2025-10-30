import java.util.Arrays;

public class GroupShow {
    private int uniqueId;
    private Show[] shows;


    public GroupShow() {
        this.uniqueId = 0;
        this.shows = new Show[0];
    }

    public GroupShow(int uniqueId, Show[] shows) {
        this.uniqueId = uniqueId;
        this.shows = shows != null ? shows : new Show[0];
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public Show[] getShows() {
        return shows;
    }

    public void setShows(Show[] shows) {
        this.shows = shows != null ? shows : new Show[0];
    }

    public Show getShow(int index) {
        if (index >= 0 && index < shows.length) {
            return shows[index];
        }
        return null;
    }

    public void setShow(int index, Show show) {
        if (index >= 0 && index < shows.length && show != null) {
            shows[index] = show;
        }
    }

    public void addShowByName(Show show) {
        if (show != null) {
            Show[] newShows = Arrays.copyOf(shows, shows.length + 1);
            newShows[shows.length] = show;
            shows = newShows;
        }
    }

    public boolean removeShowByName(String name) {
        if (name == null || shows.length == 0) {
            return false;
        }

        for (int i = 0; i < shows.length; i++) {
            if (shows[i] != null && name.equals(shows[i].getName())) {
                // Создаем новый массив без удаляемого элемента
                Show[] newShows = new Show[shows.length - 1];
                System.arraycopy(shows, 0, newShows, 0, i);
                System.arraycopy(shows, i + 1, newShows, i, shows.length - i - 1);
                shows = newShows;
                return true;
            }
        }
        return false;
    }


    public void sortByName() {
        for (int i = 0; i < shows.length - 1; i++) {
            for (int j = 0; j < shows.length - i - 1; j++) {
                if (shows[j] != null && shows[j + 1] != null) {
                    if (shows[j].getName().compareToIgnoreCase(shows[j + 1].getName()) > 0) {
                        Show temp = shows[j];
                        shows[j] = shows[j + 1];
                        shows[j + 1] = temp;
                    }
                }
            }
        }
    }

    public int getShowsCount() {
        return shows.length;
    }

    public void displayAllShows() {
        System.out.println("Группа передач #" + uniqueId);
        System.out.println("Количество передач: " + getShowsCount());

        for (int i = 0; i < shows.length; i++) {
            if (shows[i] != null) {
                System.out.println(shows[i]);
                System.out.println();
            }
        }
    }
}