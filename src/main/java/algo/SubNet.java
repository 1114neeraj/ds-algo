package algo;

import org.apache.commons.net.util.SubnetUtils;

public class SubNet {

	private static class SubnetInfo {
		
		SubnetUtils subnetUtil;
		String cidr;
		
		public SubnetInfo(SubnetUtils subnetUtil, String cidr) {
			this.subnetUtil = subnetUtil;
			this.cidr = cidr;
		}
		
	}
	
	public static void main(String[] args) {
		String[] cidrs = {"192.168.0.0/24", "10.1.0.0/16", "192.168.1.0/26",
				"172.16.100.0/24", "10.2.1.0/16", "192.168.1.64/26"};
		String ip = "192.168.1.128";
		SubnetInfo[] subnetInfo = getSubnetInfo(cidrs);
		System.out.println(getCidr(ip, subnetInfo));
	}
	
	private static SubnetInfo[] getSubnetInfo(String[] cidrs) {
		
		SubnetInfo[] subnets = new SubnetInfo[cidrs.length];
		
		for(int i=0;i<cidrs.length;i++) {
			subnets[i] = new SubnetInfo(new SubnetUtils(cidrs[i]), cidrs[i]);
		}
		
		return subnets;
	}
	
	private static String getCidr(String ip, SubnetInfo[] subnetInfo) {
		
		for(SubnetInfo subnet : subnetInfo) {
			
			if(subnet.subnetUtil.getInfo().isInRange(ip)) {
				return subnet.cidr;
			}
			
		}
		
		return null;
	}
}
