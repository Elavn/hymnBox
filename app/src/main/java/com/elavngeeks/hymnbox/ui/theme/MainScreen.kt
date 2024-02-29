package com.elavngeeks.hymnbox.ui.theme

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elavngeeks.hymnbox.R
import com.elavngeeks.hymnbox.ui.theme.ui.theme.HymnBoxTheme
import kotlinx.coroutines.launch

class MainScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HymnBoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {

                }
            }
        }
    }
}

@Composable
fun TopSection() {
    Row(
        modifier = Modifier
            .padding(start = 18.dp, top = 16.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(bottom = 10.dp),
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontFamily = epilogueregular
                    )
                ) {
                    append("hymn")
                }
                withStyle(
                    SpanStyle(
                        color = Color.White,
                        fontSize = 18.sp,
                        fontFamily = epiloguebold
                    )
                ) {
                    append("BOX")
                }
            }
        )

    }
}

@Composable
fun DescriptionText() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp)
    ) {
        Text(
            text = "Discover, sing and enjoy",
            fontFamily = epiloguebold,
            fontSize = 18.sp,
            color = Color.White
        )
        Text(
            text = "The Best of Hymns",
            fontFamily = epiloguebold,
            fontSize = 26.sp,
            color = Color.White
        )
    }
}

@Composable
fun SearchBar() {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .requiredHeight(height = 45.dp)
            .padding(horizontal = 18.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(8.dp))
                .background(color = Color(0xff333333))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .offset(
                        x = 10.dp,
                        y = 0.dp
                    )
                    .requiredSize(size = 16.dp)
            )
            Text(
                text = "Search an Efik/English Hymn",
                color = Color(0xfffcfcfc).copy(alpha = 0.4f),
                fontSize = 16.sp,
                fontFamily = epilogueregular,
                modifier = Modifier
                    .padding(start = 18.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(align = Alignment.CenterVertically)
            )
            Icon(
                painter = painterResource(id = R.drawable.mic),
                contentDescription = "Icon",
                tint = Color.White,
                modifier = Modifier
                    .offset(
                        x = (-20).dp,
                        y = 0.dp
                    )
                    .requiredSize(size = 18.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HymnTab(
    pages: MutableList<String> = arrayListOf(
        "Efik Hymns",
        "English Hymns"
    )
){
    val context = LocalContext.current
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator()
            },
            containerColor = Color(context.resources.getColor(R.color.white, null)),
            ) {
            pages.forEachIndexed {index, title ->
                val isSelected = pagerState.currentPage == index

                TabHeader(
                    title,
                    isSelected,
                    onClick = {coroutineScope.launch {
                        pagerState.animateScrollToPage(index)}},
                )
            }
        }
        HorizontalPager(
            pageCount = pages.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.Black)
            
        ) { page ->  
            
            HymnList(hymnslist = HymnDataSource().loadHymns())
            
        }
    }
}

@Composable
fun HymnList(hymnslist: List<Hymnslist>){
    LazyColumn{
        items(hymnslist){ hymns ->
            Hymnsssss(hymns)

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Hymnsssss(hymnslist: Hymnslist){

    Card(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(vertical = 12.dp, horizontal = 20.dp),
        onClick = { /*TODO*/ },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, start = 10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = hymnslist.id,
                    fontSize = 14.sp,
                    fontFamily = epilogueregular,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 8.dp)
                )

                Text(
                    text = hymnslist.hymnName,
                    fontSize = 20.sp,
                    fontFamily = epiloguesbold,
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 15.dp)

                )

                Icon(
                    painter = painterResource(id = R.drawable.forward),
                    contentDescription = "",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(30.dp)

                )
            }

            Spacer(
                modifier = Modifier
                    .height(10.dp)
                    .background(Color.Black)
            )

            Divider(
                thickness = 2.dp,
                color = Color.White.copy(alpha = 0.7f),
                modifier = Modifier
                    .padding(top = 8.dp, start = 10.dp, end = 10.dp)
            )
        }
    }
}

@Composable
private fun TabHeader(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    val color = if (isSelected) R.color.white else R.color.white
    val ripple =
        rememberRipple(bounded = true, color = Color(context.resources.getColor(color, null)))
    val interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .selectable(
                selected = isSelected,
                onClick = { onClick() },
                enabled = true,
                role = Role.Tab,
                interactionSource = interactionSource,
                indication = ripple
            )
            .padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        TabCarousel(title = title, isSelected = isSelected)
    }
}

@RequiresApi(Build.VERSION_CODES.M)
@Composable
private fun TabCarousel(title: String, isSelected: Boolean) {
    val context = LocalContext.current
    val color = if (isSelected) R.color.purple_700 else R.color.white
    val textColor = Color.White
    Row(
        modifier = Modifier
            .background(
                color = Color(context.resources.getColor(color, null)),
                shape = RoundedCornerShape(25.dp)
            )
            .padding(vertical = 15.dp, horizontal = 15.dp)
            .width(if (title.length < 11) 70.dp else 110.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Text(
            text = title,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun MainScreenPreview(){
    Column {
        TopSection()
        DescriptionText()
        SearchBar()
    }
}

val epiloguebold = FontFamily(Font(R.font.epiloguebold))
val epilogueregular = FontFamily(Font(R.font.epilogueregular))
val epiloguesbold = FontFamily(Font(R.font.epiloguesemibold))