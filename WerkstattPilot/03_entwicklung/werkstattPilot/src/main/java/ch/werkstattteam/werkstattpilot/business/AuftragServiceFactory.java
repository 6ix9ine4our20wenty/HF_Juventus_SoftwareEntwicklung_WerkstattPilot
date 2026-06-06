package ch.werkstattteam.werkstattpilot.business;

import ch.werkstattteam.werkstattpilot.persistence.AuftragRepository;
import ch.werkstattteam.werkstattpilot.persistence.AuftragRepositoryFactory;

/*
 * WerkstattPilot - Software Engineering 1
 * Aufgabe 5: Objektorientierte Implementation
 * Datei: AuftragServiceFactory.java
 * Autoren: Livio Luna, Dominic Lolos
 * Beschreibung: Einfache Singleton-Factory für den AuftragService.
 */

/**
 * Liefert zentral einen AuftragService.
 */
public class AuftragServiceFactory {

    private static AuftragServiceFactory instance;

    private AuftragServiceFactory() {
    }

    /**
     * Gibt die einzige Instanz der Factory zurück.
     *
     * @return Factory-Instanz
     */
    public static AuftragServiceFactory getInstance() {
        if (instance == null) {
            instance = new AuftragServiceFactory();
        }

        return instance;
    }

    /**
     * Erstellt einen AuftragService mit dem Mock-Repository.
     *
     * @return AuftragService für die Business-Schicht
     */
    public AuftragService createAuftragService() {
        AuftragRepository repository = AuftragRepositoryFactory.getInstance().createAuftragRepository();
        return new AuftragServiceImpl(repository);
    }
}
