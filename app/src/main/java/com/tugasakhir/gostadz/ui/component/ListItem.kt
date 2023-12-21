package com.tugasakhir.gostadz.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PersonRemove
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.tugasakhir.gostadz.R
import com.tugasakhir.gostadz.ui.theme.Primary

@Composable
fun ListItem(
    name: String,
    modifier: Modifier = Modifier,
    onClick1: () -> Unit = {},
    onClick2: () -> Unit = {}
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF7D4),
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.clickable {}.height(60.dp),
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Medium,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .width(175.dp)
            )
            Spacer(modifier = Modifier.padding(start = 48.dp))
            Row(
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = { onClick1() }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.person_edit),
                        contentDescription = "Add",
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp),
                        tint = Primary
                    )
                }
                Spacer(modifier = Modifier.padding(start = 8.dp))
                IconButton(onClick = { onClick2() }){
                    Icon(
                        imageVector = Icons.Default.PersonRemove,
                        contentDescription = "Add",
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp),
                        tint = Color.Red
                    )
                }
            }
            Spacer(modifier = Modifier.padding(start = 8.dp))
        }
    }
}



@Composable
fun ListLaporanMengaji(
    id: String,
    nama: String,
    surah: String,
    ayat: String,
    modifier: Modifier = Modifier,
    onEdit: (String) -> Unit
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF7D4),
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.clickable {}.height(60.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Text(
                    text = nama,
                    fontWeight = FontWeight.Medium,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .width(100.dp)
                )

                Text(
                    text = surah,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .width(100.dp)
                )
                Text(
                    text = ayat,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .width(35.dp)
                )
            }
            IconButton(onClick = {
                onEdit(id)
            }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.person_edit),
                    contentDescription = "Edit",
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp),
                    tint = Primary
                )
            }
        }
    }
    Spacer(modifier = Modifier.padding(top = 16.dp))
}


@Composable
fun ListItemJadwal(
    tanggal: String,
    jam: String,
    kegiatan: String,
    modifier: Modifier = Modifier,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF7D4),
        ),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.clickable {}.height(60.dp),
        ) {
            Text(
                text = tanggal,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.padding(start = 4.dp))
            Text(
                text = jam,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Text(
                text = kegiatan,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
        }
    }
    Spacer(modifier = Modifier.padding(top = 16.dp))
}


@Composable
fun ListItemVideo(
    id: String,
    title: String,
    photoUrl: String,
    modifier: Modifier = Modifier,
    onEdit: (String) -> Unit,
    onDelete: (String) -> Unit,
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF7D4),
        ),
        modifier = modifier
            .fillMaxWidth()
            .clickable { }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = photoUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.3f)
                    .height(77.63.dp)
                    .clip(RoundedCornerShape(5.dp)),

                )
            Text(
                text = title,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(start = 5.dp),
                overflow = TextOverflow.Ellipsis,
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                IconButton(onClick = { onEdit(id) }) {
                    Icon(painter = painterResource(R.drawable.person_edit), contentDescription = null)
                }
                IconButton(onClick = { onDelete(id) }) {
                    Icon(imageVector = Icons.Default.PersonRemove, contentDescription = null)
                }
            }
        }
    }
    Spacer(modifier = Modifier.padding(top = 8.dp))
}


@Composable
fun ListItemMenuVideo(
    title: String,
    photoUrl: String,
    onClick: () -> Unit
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF7D4),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = photoUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .width(138.dp)
                    .height(77.63.dp)
                    .clip(RoundedCornerShape(5.dp)),
            )
            Text(
                text = title,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis,
                fontFamily = poppins,
                color = Primary,
                modifier = Modifier
                    .width(50.dp)
                    .weight(1f)
                    .padding(start = 16.dp)
            )
        }

        @Composable
        fun ListDaftarItemVideo(
            title: String,
            photoUrl: String,
            modifier: Modifier = Modifier,
            onClick1: () -> Unit,
            onClick2: () -> Unit
        ) {
            ElevatedCard(
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFF7D4),
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AsyncImage(
                        model = photoUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(8.dp)
                            .width(138.dp)
                            .height(77.63.dp)
                            .clip(RoundedCornerShape(5.dp)),
                    )
                    Text(
                        text = title,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        fontFamily = poppins,
                        color = Primary,
                        modifier = Modifier
                            .width(50.dp)
                            .weight(1f)
                            .padding(start = 16.dp)
                    )
                    Button(
                        onClick = { onClick1() },
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,

                            ),
                        border = BorderStroke(1.dp, Primary),
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.person_edit),
                            contentDescription = "Add",
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp),
                            tint = Primary
                        )
                    }
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                    Button(
                        onClick = { onClick2() },
                        shape = RoundedCornerShape(5.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                        ),
                        border = BorderStroke(1.dp, Primary),
                    ) {
                        Icon(
                            imageVector = Icons.Default.PersonRemove,
                            contentDescription = "Add",
                            modifier = Modifier
                                .height(24.dp)
                                .width(24.dp),
                            tint = Color.Red
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(top = 16.dp))
            }

        }
    }
}




