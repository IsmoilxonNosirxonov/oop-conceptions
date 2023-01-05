package click.server.model;

public abstract class Id_creator {
    protected String id;
    private static int idCounter = 0;

    public Id_creator() {
        idCounter++;
        id = String.valueOf(idCounter);
    }

    public String getId() {
        return id;
    }
}
