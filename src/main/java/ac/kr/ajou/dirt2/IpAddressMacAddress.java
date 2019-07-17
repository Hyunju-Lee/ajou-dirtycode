package ac.kr.ajou.dirt2;

import java.util.HashSet;
import java.util.Set;

public class IpAddressMacAddress {//PC방에서 접속하는지 알기위해 ip와 mac address를 수집한다.

    // single ip, single mac, accountId, ip + mac - 4가지 메소드로 extract한다.
    public Set<String> buildCombinedIdentification(PcBangEvent pbe) {
        Set<String> combinedIdentification = new HashSet<String>();

        // single IP
        buildForSingleIp(pbe, combinedIdentification);

        // single mac
        buildForSingleMac(pbe, combinedIdentification);

        // accountId
        buildForAccountId(pbe, combinedIdentification);

        // ip + mac
        buildForIpAndMac(pbe, combinedIdentification);

        return combinedIdentification;
    }

    private void buildForIpAndMac(PcBangEvent pbe, Set<String> combinedIdentification) {
        if (pbe.getMac() != null && !pbe.getMac().isEmpty()) {
            if (pbe.getIp() != null && !pbe.getIp().isEmpty()) {
                String[] macAddresses = pbe.getMac().split(",");
                if (macAddresses.length <= 100) {
                    for (int i = 0; i < macAddresses.length; i++) {
                        combinedIdentification.add(pbe.getIp() + macAddresses[i]);
                    }
                }
            }
        }
    }

    private void buildForAccountId(PcBangEvent pbe, Set<String> combinedIdentification) {
        if (isVaildAccountId(pbe.getAccountId())) {
            if (!pbe.getAccountId().equals("0")) {
                combinedIdentification.add(pbe.getAccountId());
            } else {
                System.out.println("Account id can't be 0");
            }
        }
        System.out.println("Account is is null or empty");

    }

    private boolean isVaildAccountId(String accountId) {
        return accountId != null && !accountId.isEmpty();
    }

    private void buildForSingleMac(PcBangEvent pbe, Set<String> combinedIdentification) {
        if (isValidMacAddress(pbe)) {
            String[] macAddresses = pbe.getMac().split(",");
            if (macAddresses.length <= 100) {
                for (int i = 0; i < macAddresses.length; i++) {
                    combinedIdentification.add(macAddresses[i]);
                }
            } else {
                logErrorMessage("Mac address too many");
            }
        }
        logErrorMessage("Mac address is wrong");

    }

    private void logErrorMessage(String s) {
        System.out.println(s);
    }

    private boolean isValidMacAddress(PcBangEvent pbe) {
        return pbe.getMac() != null && !pbe.getMac().isEmpty();
    }

    private void buildForSingleIp(PcBangEvent pbe, Set<String> combinedIdentification) {
        if (pbe.getIp() != null) {
            combinedIdentification.add(pbe.getIp());
        }
    }
}
