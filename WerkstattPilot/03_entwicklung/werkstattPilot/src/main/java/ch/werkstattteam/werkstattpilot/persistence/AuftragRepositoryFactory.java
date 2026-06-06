package ch.werkstattteam.werkstattpilot.persistence;

/*
 * WerkstattPilot - Software Engineering 1
 * Aufgabe 5: Objektorientierte Implementation
 * Datei: AuftragRepositoryFactory.java
 * Autoren: Livio Luna, Dominic Lolos
 * Beschreibung: Einfache Singleton-Factory für das AuftragRepository.
 */

/**
 * Liefert zentral das Mock-Repository.
 */
public class AuftragRepositoryFactory {

    private static AuftragRepositoryFactory instance;
    private AuftragRepository repository;

    private AuftragRepositoryFactory() {
        repository = new AuftragRepositoryMock();
    }

    /**
     * Gibt die einzige Instanz der Repository-Factory zurück.
     *
     * @return Factory-Instanz
     */
    public static AuftragRepositoryFactory getInstance() {
        if (instance == null) {
            instance = new AuftragRepositoryFactory();
        }

        return instance;
    }

    /**
     * Gibt das Mock-Repository zurück.
     *
     * @return Repository für Aufträge
     */
    public AuftragRepository createAuftragRepository() {
        return repository;
    }
}
