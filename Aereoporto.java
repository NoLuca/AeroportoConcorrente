public class Aereoporto {
    //  >>>>> Aree <<<<<
        // Piste: 3, 1 aereo
            // Decollo e atterraggio

        // AreaSosta: 1, 3 aerei
            // Rifornimento aerei, carico e scarico bagagli e viaggiatori
            // Valore boolean per viaggio di sola andata o anche ritorno
        
        // Hangar: 1, 5 aerei
            // Aerei che non viaggiano


    //  >>>>> Veicoli <<<<<
        // Aerei:
            // Codice del volo
            // Impresa costruttrice
            // Numero max di passeggeri
            // Numero di passeggeri
            // Peso max dei bagagli
            // Peso dei bagagli contenuti
            // Valore boolean per viaggio di sola andata o ritorno
         
        // VeicoloRifornimento:
            // Riforniscono gli aerei solo quando gli aerei sono in area di sosta prima del decollo
            
        
        // VeicoloViaggiatori:
            // Solo quando gli aerei sono in area di sosta
            // Prima del decollo caricano bagagli
            // Dopo l'atterraggio scaricano bagagli
        
        // Un solo veicolo di servizio alla volta può avvicinarsi all'aereo
            // O rifornisce o carica/scarica bagagli
            // Passeggeri avvengono in parallelo

}
