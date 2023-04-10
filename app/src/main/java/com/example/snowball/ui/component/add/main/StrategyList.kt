package com.example.snowball.ui.component.add

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snowball.ui.component.add.main.InsertButtonWhenEmpty
import com.example.snowball.model.add.StrategyModel
import com.example.snowball.ui.theme.MainBlack
import com.example.snowball.ui.theme.MainGreen
import com.example.snowball.ui.theme.MainGrey

@Composable
fun StrategyList(
    strategyList: List<StrategyModel>,
    navigateToSelectScreen: () -> Unit
) {
    StrategyNumberCount(strategyNumber = strategyList.size)
    StrategyListTable(
        strategyList = strategyList,
        navigateToSelectScreen = navigateToSelectScreen
    )
}

@Composable
fun StrategyNumberCount(
    strategyNumber: Int
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = "전략 총 ${strategyNumber}개",
            fontSize = 20.sp
        )
    }

}

@Composable
fun StrategyListTable(
    strategyList: List<StrategyModel>,
    navigateToSelectScreen: () -> Unit
) {
    StrategyListTableHeader()
    StrategyListTableBody(
        strategyList = strategyList,
        navigateToSelectScreen = navigateToSelectScreen
    )
}

@Composable
fun StrategyListTableHeader(){
    
    @Composable
    fun HeaderText(value: String){
        Text(
            text = value,
            color = MainGreen,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
            
    Divider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 2.dp,
        color = MainGreen
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        HeaderText(value = "전략명")
        Row() {
            HeaderText(value = "개수")
            Spacer(modifier = Modifier.padding(horizontal = 20.dp))
            HeaderText(value = "%   ")
        }
    }
}

@Composable
fun StrategyListTableBody(
    strategyList: List<StrategyModel>,
    navigateToSelectScreen: () -> Unit
){
    @Composable
    fun BodyItem(
        strategy: StrategyModel
    ) {
        @Composable
        fun BodyText(value: String){
            Text(
                text = value,
                color = MainBlack,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            BodyText(value = strategy.productName)
            Row() {
                BodyText(value = strategy.productNumber.toString())
                Spacer(modifier = Modifier.padding(horizontal = 20.dp))
                BodyText(value = strategy.productRate.toString() + "%")
            }
        }
    }
    
    Divider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 1.dp,
        color = MainGreen
    )
    if (strategyList.isEmpty()) {
        Column(
            modifier = Modifier
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "등록된 전략이 없습니다")
            }
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            InsertButtonWhenEmpty(
                navigateToSelectScreen = navigateToSelectScreen
            )
        }
    } else {
        strategyList.forEachIndexed {index, item ->
            BodyItem(strategy = item)
            if(index != strategyList.size-1){
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = MainGrey
                )
            }
        }
    }
    Divider(
        modifier = Modifier.fillMaxWidth(),
        thickness = 1.dp,
        color = MainGreen
    )
}