package ChipiChapa;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Karyawan {
	private static final String[] JABATAN_LIST = {"Manager", "Supervisor", "Admin"};
	private static final Map<String, Integer> GAJI_MAP = new HashMap<>();
	private static final Map<String, Integer> BONUS_MAP = new HashMap<>();
	private static final Set<String> kodeKaryawanSet = new HashSet<>();
	private static final Scanner scanner = new Scanner(System.in);

	  static {
	    GAJI_MAP.put("Manager", 8000000);
	    GAJI_MAP.put("Supervisor", 6000000);
	    GAJI_MAP.put("Admin", 4000000);

	    BONUS_MAP.put("Manager", 10);
	    BONUS_MAP.put("Supervisor", 75);
	    BONUS_MAP.put("Admin", 5);
	  }
	  
	public Karyawan(String kode, String string, String string2, String string3, int i) {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		while (true) {
		      tampilkanMenu();
		      int pilihan = scanner.nextInt();
		      scanner.nextLine();
		      switch (pilihan) {
		        case 1:
		          insertDataKaryawan();
		          break;
		        case 2:
		          viewDataKaryawan();
		          break;
		        case 3:
		          updateDataKaryawan();
		          break;
		        case 4:
		          deleteDataKaryawan();
		          break;
		        case 0:
		          System.out.println("Terima kasih telah menggunakan program!");
		          System.exit(0);
		        default:
		          System.out.println("Pilihan tidak valid!");
		      }}
		    }
		 private static void tampilkanMenu() {
			    System.out.println("\n--- Aplikasi PT ChipiChapa ---");
			    System.out.println("1. Insert Data Karyawan");
			    System.out.println("2. View Data Karyawan");
			    System.out.println("3. Update Data Karyawan");
			    System.out.println("4. Delete Data Karyawan");
			    System.out.println("0. Keluar");
			    System.out.print("Masukkan pilihan Anda: ");
			  }

		 private static void insertDataKaryawan() {
			    String kodeKaryawan = getNamaKaryawan();
			    System.out.print("Masukkan nama karyawan: ");
			    String namaKaryawan = scanner.nextLine();
			    System.out.print("Masukkan jenis kelamin (Laki-Laki/Perempuan): ");
			    String jenisKelamin = scanner.nextLine();
			    System.out.print("Masukkan jabatan (Manager/Supervisor/Admin): ");
			    String jabatan = scanner.nextLine();

			    int gaji = 0;
			    switch (jabatan) {
			        case "Manager":
			            gaji = 8000000;
			            break;
			        case "Supervisor":
			            gaji = 6000000;
			            break;
			        case "Admin":
			            gaji = 4000000;
			            break;
			    }
	}
		 private static void viewDataKaryawan() {
				  if (kodeKaryawanSet.isEmpty()) {
				    System.out.println("Masukkan data karyawan.");
				    return;
				  }
				  List<Karyawan> daftarKaryawan = kodeKaryawanSet.stream()
				      .map(kode -> findKaryawanByKodeKaryawan(kode))
				      .sorted(Comparator(Karyawan::getNamaKaryawan))
				      .collect(Collectors.toList());

				  System.out.println("\n--- Daftar Karyawan ---");
				  System.out.format("| %-10s | %-20s | %-10s | %-10s | %-10s |\n",
				      "Kode", "Nama", "Jenis Kelamin", "Jabatan", "Gaji");
				  for (Karyawan karyawan : daftarKaryawan) {
				    System.out.format("| %-10s | %-20s | %-10s | %-10s | %-10s |\n",
				        karyawan.getKodeKaryawan(),
				        karyawan.getNamaKaryawan(),
				        karyawan.getJenisKelamin(),
				        karyawan.getJabatan(),
				        karyawan.getGaji());
				  }
				}

				private Object getGaji() {
			return null;
		}
				private Object getJabatan() {
			return null;
		}
				private Object getJenisKelamin() {
			return null;
		}
				private Object getKodeKaryawan() {
			return null;
		}
				private static Karyawan findKaryawanByKodeKaryawan(String kodeKaryawan) {
				  return kodeKaryawanSet.stream()
				      .filter(kode -> kode.equals(kodeKaryawan))
				      .map(kode -> new Karyawan(kode, "", "", "", 0))
				      .findFirst()
				      .orElse(null);
				}
				private static void updateDataKaryawan() {
					  if (kodeKaryawanSet.isEmpty()) {
					    System.out.println("Belum ada data karyawan yang dimasukkan!");
					    return;
					  }

					  
					  List<Karyawan> daftarKaryawan = viewDataKaryawanAscByName();
					  int pilihan = pilihDataKaryawan(daftarKaryawan);
					  if (pilihan == 0) {
					    System.out.println("Pembatalan update data karyawan!");
					    return;
					  }

					  Karyawan karyawan = daftarKaryawan.get(pilihan - 1);
					  
					  String kodeKaryawanBaru = inputDataKaryawanBaru(karyawan.getKodeKaryawan());
					  String namaKaryawanBaru = inputDataKaryawanBaru(karyawan.getNamaKaryawan());
					  String jenisKelaminBaru = inputDataKaryawanBaru(karyawan.getJenisKelamin());
					  String jabatanBaru = inputDataKaryawanBaru(karyawan.getJabatan());
					  int gajiBaru = hitungGaji(jabatanBaru);

					  if (!kodeKaryawanBaru.equals("0")) {
					    karyawan.setKodeKaryawan(kodeKaryawanBaru);
					  }
					  if (!namaKaryawanBaru.equals("0")) {
					    karyawan.setNamaKaryawan(namaKaryawanBaru);
					  }
					  if (!jenisKelaminBaru.equals("0")) {
					    karyawan.setJenisKelamin(jenisKelaminBaru);
					  }
					  if (!jabatanBaru.equals("0")) {
					    karyawan.setJabatan(jabatanBaru);
					    karyawan.setGaji(gajiBaru);
					  }

					  System.out.println("Data karyawan berhasil diubah!");
					}

					private void setGaji(int gajiBaru) {
					
				}
					private void setJabatan(String jabatanBaru) {
					
				}
					private void setJenisKelamin(String jenisKelaminBaru) {
					
				}
					private void setNamaKaryawan(String namaKaryawanBaru) {
					
				}
					private void setKodeKaryawan(String kodeKaryawanBaru) {
					
				}
					private static int hitungGaji(String jabatanBaru) {
					return 0;
				}
					private static List<Karyawan> viewDataKaryawanAscByName() {
					  
					  List<Karyawan> daftarKaryawan = kodeKaryawanSet.stream()
					      .map(kode -> findKaryawanByKodeKaryawan(kode))
					      .sorted(Comparator(Karyawan::getNamaKaryawan))
					      .collect(Collectors.toList());

					  System.out.println("\n--- Daftar Karyawan ---");
					  System.out.format("| No. | Kode     | Nama                   | Jenis Kelamin | Jabatan | Gaji     |\n");
					  for (int i = 0; i < daftarKaryawan.size(); i++) {
					    Karyawan karyawan = daftarKaryawan.get(i);
					    System.out.format("| %2d | %-10s | %-20s | %-10s | %-10s | %-10s |\n",
					        i + 1,
					        karyawan.getKodeKaryawan(),
					        karyawan.getNamaKaryawan(),
					        karyawan.getJenisKelamin(),
					        karyawan.getJabatan(),
					        karyawan.getGaji());
					  }

					  return daftarKaryawan;
					}

					private static Comparator<? super Karyawan> Comparator(Object object) {
						return null;
					}
					private static int pilihDataKaryawan(List<Karyawan> daftarKaryawan) {
					  int pilihan;
					  do {
					    System.out.print("Masukkan nomor data yang ingin diubah (1-" + daftarKaryawan.size() + ") atau 0 untuk batal: ");
					    try {
					      pilihan = scanner.nextInt();
					    } catch (InputMismatchException e) {
					      pilihan = 0;
					    }
					    scanner.nextLine();
					  } while (pilihan < 0 || pilihan > daftarKaryawan.size());

					  return pilihan;
					}

					private static String inputDataKaryawanBaru(Object object) {
					  System.out.print("Masukkan " + object + " baru (0 untuk tidak mengubah): ");
					  String dataBaru = scanner.nextLine();
					  return dataBaru.isEmpty() ? (String) object : dataBaru;
					}
					/**
					 * 
					 */
					private static void deleteDataKaryawan() {
						  if (kodeKaryawanSet.isEmpty()) {
						    System.out.println("Belum ada data karyawan yang dimasukkan!");
						    return;
						  }

						  List<Karyawan> daftarKaryawan = viewDataKaryawanAscByName();
						  int pilihan = pilihDataKaryawan(daftarKaryawan);
						  if (pilihan == 0) {
						    System.out.println("Pembatalan hapus data karyawan!");
						    return;
						  }

						  Karyawan karyawan = daftarKaryawan.get(pilihan - 1);

						  System.out.print("Apakah Anda yakin ingin menghapus data karyawan " + karyawan.getNamaKaryawan() + " (Y/T)? ");
						  String konfirmasi = scanner.nextLine().toUpperCase();
						  if (!konfirmasi.equals("Y")) {
						    System.out.println("Penghapusan data karyawan dibatalkan!");
						    return;
						  }

						  System.out.println("Data karyawan " + karyawan.getNamaKaryawan() + " berhasil dihapus!");
						}
					private static String getNamaKaryawan() {
						return null;
					}

		 }

