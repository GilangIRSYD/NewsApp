data class ResponseBerita(

	@field:SerializedName("data_berita")
	val dataBerita: List<DataBeritaItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)

data class DataBeritaItem(

	@field:SerializedName("penulis_berita")
	val penulisBerita: String? = null,

	@field:SerializedName("image_berita")
	val imageBerita: String? = null,

	@field:SerializedName("id_berita")
	val idBerita: String? = null,

	@field:SerializedName("judul_berita")
	val judulBerita: String? = null,

	@field:SerializedName("isi_berita")
	val isiBerita: String? = null
)

