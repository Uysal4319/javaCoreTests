package dataTypesOperations.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Kpi {
	
	KpiCC_1(1, "3,10", 0, "Unallocated (unassigned) number"),
	KpiCC_3(3, "3,10", 1, "No route to destination"),
	KpiCC_6(6, "3,10", 2, "Channel unacceptable"),
	KpiCC_8(8, "3,10", 3, "Operator determined baring"),
	KpiCC_16(16, "3,10", 4, "Normal call clearing"),
	KpiCC_17(17, "3,10", 5, "User busy"),
	KpiCC_18(18, "3,10", 6, "No user responding"),
	KpiCC_19(19, "3,10", 7, "No answer from user (user alerted)"),
	KpiCC_21(21, "3,10", 8, "Call rejected"),
	KpiCC_22(22, "3,10", 9, "Number changed"),
	KpiCC_24(24, "3,10", 10, "Unknown business group (ANSI)"),
	KpiCC_25(25, "3,10", 11, "Exchange routing error (ANSI)"),
	KpiCC_26(26, "3,10", 12, "Non-selected user clearing"),
	KpiCC_27(27, "3,10", 13, "Destination out of order"),
	KpiCC_28(28, "3,10", 14, "Invalid number format"),
	KpiCC_29(29, "3,10", 15, "Facility rejected"),
	KpiCC_30(30, "3,10", 16, "Response to STATUS ENQUIRY"),
	KpiCC_31(31, "3,10", 17, "Normal, unspecified"),
	KpiCC_34(34, "3,10", 18, "No circuit/channel available"),
	KpiCC_38(38, "3,10", 19, "Network out of order"),
	KpiCC_41(41, "3,10", 20, "Temporary failure"),
	KpiCC_42(42, "3,10", 21, "Switching equipment congestion"),
	KpiCC_43(43, "3,10", 22, "Access information discarded"),
	KpiCC_44(44, "3,10", 23, "Requested channel/circuit not available"),
	KpiCC_47(47, "3,10", 24, "Resources unavailable, unspecified"),
	KpiCC_49(49, "3,10", 25, "Quality of service unavailable"),
	KpiCC_50(50, "3,10", 26, "Requested facility not subscribed"),
	KpiCC_55(55, "3,10", 27, "Incoming calls barred within CUG"),
	KpiCC_57(57, "3,10", 28, "Bearer capability not authorized"),
	KpiCC_58(58, "3,10", 29, "Bearer capability not presently available"),
	KpiCC_63(63, "3,10", 30, "Service or option not available, unspecified"),
	KpiCC_65(65, "3,10", 31, "Bearer capability not implemented"),
	KpiCC_68(68, "3,10", 32, "ACM equal to or greater than ACMmax"),
	KpiCC_69(69, "3,10", 33, "Requested facility not implemented"),
	KpiCC_70(70, "3,10", 34, "Only restricted digital bearer cap. is available"),
	KpiCC_79(79, "3,10", 35, "Service or option not implemented, unspecified"),
	KpiCC_81(81, "3,10", 36, "Invalid call reference value"),
	KpiCC_87(87, "3,10", 37, "User not member of CUG"),
	KpiCC_88(88, "3,10", 38, "Incompatible destination"),
	KpiCC_91(91, "3,10", 39, "Invalid transit network selection"),
	KpiCC_95(95, "3,10", 40, "Invalid message, unspecified"),
	KpiCC_96(96, "3,10", 41, "Mandatory information element is missing"),
	KpiCC_97(97, "3,10", 42, "Message type non-existing or not implemented"),
	KpiCC_98(98, "3,10", 43, "Message incompatible with call state or mesg type "),
	KpiCC_99(99, "3,10", 44, "Information element non-existent or not implemente"),
	KpiCC_100(100, "3,10", 45, "Invalid information element contents"),
	KpiCC_101(101, "3,10", 46, "Message not compatible with call state"),
	KpiCC_102(102, "3,10", 47, "Recovery on timer expiry"),
	KpiCC_111(111, "3,10", 48, "Protocol error, unspecified"),
	KpiCC_127(127, "3,10", 49, "Interworking, unspecified"),
	
	// DTAP - MM
	KpiMM_2(2, "2,9", 50, "MSI unknown in HLR"),
	KpiMM_3(3, "2,9", 51, "Illegal MS"),
	KpiMM_4(4, "2,9", 52, "IMSI unknown in VLR"),
	KpiMM_5(5, "2,9", 53, "IMEI not accepted"),
	KpiMM_6(6, "2,9", 54, "Illegal ME"),
	KpiMM_11(11, "2,9", 55, "PLMN not allowed"),
	KpiMM_12(12, "2,9", 56, "Location Area not allowed"),
	KpiMM_13(13, "2,9", 57, "Roaming not allowed in this location area"),
	KpiMM_15(15, "2,9", 58, "No Suitable Cells In Location Area"),
	KpiMM_17(17, "2,9", 59, "Network failure"),
	KpiMM_20(20, "2,9", 60, "MAC failure"),
	KpiMM_21(21, "2,9", 61, "Synch failure"),
	KpiMM_22(22, "2,9", 62, "Congestion"),
	KpiMM_23(23, "2,9", 63, "GSM authentication unacceptable"),
	KpiMM_25(25, "2,9", 64, "Not authorized for this CSG"),
	KpiMM_32(32, "2,9", 65, "Service option not supported"),
	KpiMM_33(33, "2,9", 66, "Requested service option not subscribed"),
	KpiMM_34(34, "2,9", 67, "Service option temporarily out of order"),
	KpiMM_38(38, "2,9", 68, "Call cannot be identified"),
	KpiMM_95(95, "2,9", 69, "Semantically incorrect message"),
	KpiMM_96(96, "2,9", 70, "Invalid mandatory information"),
	KpiMM_97(97, "2,9", 71, "Message type non-existent or not implemented"),
	KpiMM_98(98, "2,9", 72, "Message type not compatible with the protocol stat"),
	KpiMM_99(99, "2,9", 73, "Information element non-existent or not implemente"),
	KpiMM_100(100, "2,9", 74, "Conditional IE error"),
	KpiMM_101(101, "2,9", 75, "Message not compatible with the protocol state"),
	KpiMM_111(111, "2,9", 76, "Protocol error unspecified"),
	
	// BSSMAP
	Kpi_0(0, "0,7", 77, "Radio interface message failure"),
	Kpi_1(1, "0,7", 78, "Radio interface failure"),
	Kpi_2(2, "0,7", 79, "Uplink quality"),
	Kpi_3(3, "0,7", 80, "Uplink strength"),
	Kpi_4(4, "0,7", 81, "Downlink quality"),
	Kpi_5(5, "0,7", 82, "Downlink strength"),
	Kpi_6(6, "0,7", 83, "Distance"),
	Kpi_7(7, "0,7", 84, "O&M intervention"),
	Kpi_8(8, "0,7", 85, "Response to MSC invocation"),
	Kpi_9(9, "0,7", 86, "Call control"),
	Kpi_10(10, "0,7", 87, "Radio interface failure, reversion to old channel"),
	Kpi_11(11, "0,7", 88, "Handover successful"),
	Kpi_12(12, "0,7", 89, "BetterCell"),
	Kpi_13(13, "0,7", 90, "Directed Retry"),
	Kpi_14(14, "0,7", 91, "Joined group call channel"),
	Kpi_15(15, "0,7", 92, "Traffic"),
	Kpi_16(16, "0,7", 93, "Reduce load in serving cell"),
	Kpi_17(17, "0,7", 94, "Traffic load in target cell higher than in source"),
	Kpi_18(18, "0,7", 95, "Relocation triggered"),
	Kpi_20(20, "0,7", 96, "Requested option not authorised"),
	Kpi_21(21, "0,7", 97, "Alternative channel configuration requested"),
	Kpi_22(22, "0,7", 98, "Response to an INTERNAL HANDOVER ENQUIRY message"),
	Kpi_23(23, "0,7", 99, "INTERNAL HANDOVER ENQUIRY reject"),
	Kpi_24(24, "0,7", 100, "Redundancy Level not adequate"),
	Kpi_32(32, "0,7", 101, "Equipment failure"),
	Kpi_33(33, "0,7", 102, "No radio resource available"),
	Kpi_34(34, "0,7", 103, "Requested terrestrial resource unavailable"),
	Kpi_35(35, "0,7", 104, "CCCH overload"),
	Kpi_36(36, "0,7", 105, "Processor overload"),
	Kpi_37(37, "0,7", 106, "BSS not equipped"),
	Kpi_38(38, "0,7", 107, "MS not equipped"),
	Kpi_39(39, "0,7", 108, "Invalid cell"),
	Kpi_40(40, "0,7", 109, "Traffic Load"),
	Kpi_41(41, "0,7", 110, "Preemption"),
	Kpi_42(42, "0,7", 111, "DTM Handover - SGSN Failure"),
	Kpi_43(43, "0,7", 112, "DTM Handover - PS Allocation failure"),
	Kpi_48(48, "0,7", 113, "Requested transcoding/rate adaption unavailable"),
	Kpi_49(49, "0,7", 114, "Circuit pool mismatch"),
	Kpi_50(50, "0,7", 115, "Switch circuit pool"),
	Kpi_51(51, "0,7", 116, "BSS not equipped"),
	Kpi_52(52, "0,7", 117, "LSA not allowed"),
	Kpi_53(53, "0,7", 118, "Requested Codec Type or Codec Configuration unavai"),
	Kpi_54(54, "0,7", 119, "Requested A-Interface Type unavailable"),
	Kpi_63(63, "0,7", 120, "Requested Redundancy Level not available"),
	Kpi_64(64, "0,7", 121, "Ciphering algorithm not supported"),
	Kpi_68(68, "0,7", 122, "Requested Codec Type or Codec Configuration not su"),
	Kpi_69(69, "0,7", 123, "Requested A-Interface Type not supported"),
	Kpi_70(70, "0,7", 124, "Requested Redundancy Level not supported"),
	Kpi_80(80, "0,7", 125, "Terrestrial circuit already allocated"),
	Kpi_81(81, "0,7", 126, "Invalid message contents"),
	Kpi_82(82, "0,7", 127, "Information element or field missing"),
	Kpi_83(83, "0,7", 128, "Incorrect value"),
	Kpi_84(84, "0,7", 129, "Unknown Message type"),
	Kpi_85(85, "0,7", 130, "Unknown Information Element"),
	Kpi_86(86, "0,7", 131, "DTM Handover - Invalid PS Indication"),
	Kpi_87(87, "0,7", 132, "Call Identifier already allocated"),
	Kpi_96(96, "0,7", 133, "Protocol Error between BSS and MSC"),
	Kpi_97(97, "0,7", 134, "VGCS/VBS call non existent"),
	Kpi_98(98, "0,7", 135, "DTM Handover - Timer Expiry");
	
	
	private final int id;
	private final String classificationIds;
	private final int kpiId;
	private final String description;
	private static final List<Kpi> KPI_LIST = Arrays.asList(values());
	
	public static Map<String, Integer> kpiMap = new HashMap<String, Integer>();
	
	private Kpi(int id, String classificationIds, int kpiId, String description) {
		this.id = id;
		this.classificationIds = classificationIds;
		this.description = description;
		this.kpiId = kpiId;
	}
	
	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getKpiId() {
		return kpiId;
	}
	
	public static void fetchCauseKpiIdMap() {
		for (Kpi kpi : KPI_LIST) {
			for (String prmPd : kpi.classificationIds.split(",")) {
				String key = prmPd + "_" + kpi.id;
				kpiMap.put(key, kpi.kpiId);
			}
		}
	}
	
	public static Integer getKpiIdFromMap(String key) {
		return kpiMap.get(key);
	}
	
	public static Integer getKpiID(int classificationId, int id) {
		for (Kpi item : KPI_LIST) {
			if (item.id == id && classificationCheck(item.classificationIds.split(","), classificationId)) {
				return item.kpiId;
			}
		}
		return null;
	}
	
	private static boolean classificationCheck(String[] classificationIdList, int classificationId) {
		for (String item : classificationIdList) {
			if (item.equalsIgnoreCase(String.valueOf(classificationId))) {
				return true;
			}
		}
		return false;
	}
	
}
