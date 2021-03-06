package tp.homeDisplay.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MetroService {

	String[] metroTimeTable = 
		{
				"0511","0536","0550",
			"0603","0614","0625","0631","0641","0646","0651","0656",
			"0701","0706","0711","0716","0721","0727","0732","0737","0743","0748","0753","0759",
			"0804","0809","0816","0822","0826","0834","0840","0841","0846","0853",
			"0900","0903","0910","0913","0918","0927","0930","0938","0948","0957",
			"1000","1008","1018","1027","1030","1038","1048","1057",
			"1100","1108","1118","1127","1130","1138","1148","1157",
			"1200","1208","1218","1227","1230","1238","1248","1257",
			"1300","1308","1318","1327","1330","1338","1348","1357",
			"1400","1408","1418","1427","1430","1438","1448","1457",
			"1500","1508","1518","1527","1530","1538","1548","1557",
			"1600","1608","1618","1627","1630","1638","1648","1657",
			"1700","1708","1719","1723","1726","1732","1738","1743","1746","1752","1758",
			"1803","1806","1812","1818","1823","1826","1832","1838","1843","1846","1852","1858",
			"1903","1906","1912","1918","1923","1926","1932","1940","1945","1949","1957",
			"2003","2006","2012","2019","2027","2033","2036","2042","2049","2057",
			"2103","2106","2112","2119","2127","2133","2136","2146","2155",
			"2203","2206","2215","2225","2236","2242","2252",
			"2302","2312","2322","2333","2346","2359",
			"2411","2428"

	};
	
	public String getOncomingShift()
	{
		LocalDateTime ldt = LocalDateTime.now(); 
		String nowTime = DateTimeFormatter.ofPattern("HHmm").format(ldt);
		int index = 0;
		for(String time : metroTimeTable){
			if(time.compareTo(nowTime)> 0)
			{
				break;
			}
			index++;
		}
		String times = metroTimeTable[index] + ", ";
		if(index+1 == metroTimeTable.length)
		{
			times += metroTimeTable[0];
		}else {
			times += metroTimeTable[index + 1];
		}
		return times;
	}
}
