package Atividade4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpMain {

    public static void main(String[] args) throws UnknownHostException {
        String dns = "netflix.com";
        InetAddress singleIp = InetAddress.getByName(dns);
        System.out.println(singleIp);
        InetAddress[] listIp = InetAddress.getAllByName(dns);
        System.out.println(listIp.length);
    }
}
