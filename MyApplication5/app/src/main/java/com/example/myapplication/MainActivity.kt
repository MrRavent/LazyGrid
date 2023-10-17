package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // Panggil komponen Composable yang telah Anda buat
                Surface {
                    DaftarMataKuliah()
                }
            }
        }
    }
}

@Composable
fun DaftarMataKuliah() {
    val mataKuliahList by remember { mutableStateOf(generateSampleData()) }

    LazyColumn {
        items(mataKuliahList) { mataKuliah ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Tampilkan ikon/foto mata kuliah
                Image(
                    painter = painterResource(id = mataKuliah.icon),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(64.dp)
                        .background(Color.Gray)
                )

                Spacer(modifier = Modifier.width(16.dp))

                // Tampilkan nama mata kuliah dan SKS
                Column {
                    Text(
                        text = mataKuliah.nama,
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "SKS: ${mataKuliah.sks}",
                        fontSize = 16.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

// Fungsi untuk menghasilkan data mata kuliah contoh secara statis
fun generateSampleData(): List<MataKuliah> {
    return listOf(
        MataKuliah("Mata Kuliah 1", R.drawable.unj, 3),
        MataKuliah("Mata Kuliah 2", R.drawable.unj, 4),
        MataKuliah("Mata Kuliah 3", R.drawable.unj, 2),
        // Tambahkan data mata kuliah lainnya sesuai kebutuhan
    )
}
