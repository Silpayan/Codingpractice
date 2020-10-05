package pramp;

public class validIP {

	static boolean validateIPNot(String ip) {
		// your code goes here
		if (ip == null || ip.equals("")) {
			return false;
		}

		//ip = ip.replaceAll(".", "*");

		String ipParts[] = ip.split("\\.");

		System.out.println(ip);

		if (ipParts.length != 4) {
			System.out.println("ipParts.length = " + ipParts.length);
			return false;
		}

		for (String ips : ipParts) {
			System.out.println(ips);
			int num = 0;
			try {
				num = Integer.parseInt(ips);
				System.out.println(num);
			} catch (Exception e) {
				return false;
			}

			if (num < 0 || num > 255) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {

		System.out.println("\"\" : " + validateIP(""));
		System.out.println("12.34.5.6 : " + validateIP("12.34.5.6"));
		System.out.println(".34.5.6 : " + validateIP(".34.5.6"));
		System.out.println(".12.34.5.6 : " + validateIP(".12.34.5.6"));
		System.out.println("255.255.255.255 : " + validateIP("255.255.255.255"));
		System.out.println("1.2.3.4.5 : " + validateIP("1.2.3.4.5"));
		System.out.println("12.34.56.oops : " + validateIP("12.34.56.oops"));
		System.out.println("12.0.5.6 : " + validateIP("12.0.5.6"));
		System.out.println("1..23.4 : " + validateIP("1..23.4"));
		System.out.println("192.168.123.456 : " + validateIP("192.168.123.456"));
		

	}

	static boolean validateIP(String ip) {
		// your code goes here
		if (ip == null || ip.equals("") || ip.length() > 15) {
			return false;
		}

		int dotcnt = 0, num = -1;

		for (int i = 0; i < ip.length(); i++) {
			
			char c = ip.charAt(i);
			
			//System.out.print("c ="+c+", ");

			if ('.' == c) {
				if (num < 0 || num > 255) {
					return false;
				}
				if(i==0) {
					return false;
				}
				num = -1;
				dotcnt++;
				//System.out.print(" dotcnt :"+dotcnt);
				
				if (dotcnt > 3) {
					return false;
				}
			} else {
				try {
					//System.out.print(" num before :"+num);
					num = num==-1?0:num;
					num = num * 10 + Integer.parseInt(String.valueOf(c));
					//System.out.print("num :"+num);

					if(num > 255) {
						return false;
					}
				} catch (Exception e) {
					return false;
				}
			}

			//System.out.println();

		}

		return true;
	}

}
