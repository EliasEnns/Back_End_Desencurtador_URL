//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {
        Desencurtador desencurtador = new Desencurtador();

        String url = "https://shorturl.at/hii5V";

            
            desencurtador.setShortUrl(url);
            System.out.println(desencurtador.getLongUrl());

    }
}
// Saída do código: (literalmente funcionou de primeira)
//{"unshortened_url":"https://www.youtube.com/?feature=youtu.be","shortened_url":"https://shorturl.at/hii5V","success":true}
//{"unshortened_url":"https://www.youtube.com/?feature=youtu.be","shortened_url":"https://shorturl.at/hii5V","success":true}