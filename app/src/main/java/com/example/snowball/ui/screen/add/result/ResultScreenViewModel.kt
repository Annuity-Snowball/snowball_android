package com.example.snowball.ui.screen.add.result

import androidx.compose.runtime.mutableStateOf
import com.github.mikephil.charting.data.Entry

class ResultScreenViewModel {

    companion object ChartDatas {
        val onlyMoney = mutableStateOf<List<Entry>?>(null)
        val value_without_tax = mutableStateOf<List<Entry>?>(null)
        val value_with_tax = mutableStateOf<List<Entry>?>(null)
        val result_without_tax = mutableStateOf<List<Entry>?>(null)
        val result_with_tax = mutableStateOf<List<Entry>?>(null)
        val receive_without_tax = mutableStateOf<List<Entry>?>(null)
    }


    /*
        "result_without_tax": {
        "투입한 금액": 42600000,
        "포트폴리오 가치": 53232998.0,
        "총 수익률": 24.96,
        "월 수익률 추이": {
            "2017-10": 7.05,
            "2017-11": -9.27,
            "2017-12": 21.3,
            "2018-01": 4.48,
            "2018-02": -10.6,
            "2018-03": -4.9,
            "2018-04": -12.15,
            "2018-05": 7.69,
            "2018-06": 1.14,
            "2018-07": 4.45,
            "2018-08": 4.5,
            "2018-09": 7.88,
            "2018-10": -13.28,
            "2018-11": -7.05,
            "2018-12": 13.87,
            "2019-01": 0.15,
            "2019-02": -7.64,
            "2019-03": 4.92,
            "2019-04": -4.49,
            "월 수익률 평균": 0.42
        },
        "일별 수익률": {
            "2017-10-11": -3.05,
            "2017-10-12": 10.04,
            "2017-10-13": -11.67,
            "2017-10-16": -10.75,
            "2017-10-17": 7.73,
            "2017-10-18": -6.17,
            "2017-10-19": 1.57,
            "2017-10-20": -8.59,
            "2017-10-23": 8.54,
            "2017-10-24": 2.85,
            "2017-10-25": 12.42,
            "2017-10-26": 10.04,
            "2017-10-27": -5.48,
            "2017-10-30": 11.22,
            "2017-10-31": 7.05,
            "2017-11-01": 13.14,
            "2017-11-02": 2.39,
            "2017-11-03": 8.39,
            "2017-11-06": 6.37,
            "2017-11-07": 8.11,
            "2017-11-08": -8.5,
            "2017-11-09": 8.44,
            "2017-11-10": -5.51,
            "2017-11-13": 10.56,
            "2017-11-14": -4.48,
            "2017-11-15": 2.98,
            "2017-11-16": 3.37,
            "2017-11-17": 1.94,
            "2017-11-20": 6.02,
            "2017-11-21": -3.28,
            "2017-11-22": 7.41,
            "2017-11-23": -15.24,
            "2017-11-24": -10.46,
            "2017-11-27": -11.65,
            "2017-11-28": -12.11,
            "2017-11-29": -1.7,
            "2017-11-30": 2.65,
            "2017-12-01": -6.56,
            "2017-12-04": 0.89,
            "2017-12-05": 0.54,
            "2017-12-06": -5.62,
            "2017-12-07": 11.73,
            "2017-12-08": -17.3,
            "2017-12-11": -7.8,
            "2017-12-12": 22.74,
            "2017-12-13": 13.36,
            "2017-12-14": 2.53,
            "2017-12-15": -1.32,
            "2017-12-18": -8.64,
            "2017-12-19": -7.13,
            "2017-12-20": 2.41,
            "2017-12-21": -4.61,
            "2017-12-22": -9.43,
            "2017-12-26": 14.07,
            "2017-12-27": -7.19,
            "2017-12-28": 13.35,
            "2018-01-02": 3.63,
            "2018-01-03": 3.75,
            "2018-01-04": -8.81,
            "2018-01-05": -7.23,
            "2018-01-08": -4.95,
            "2018-01-09": 4.08,
            "2018-01-10": 5.38,
            "2018-01-11": -8.89,
            "2018-01-12": 2.67,
            "2018-01-15": -8.59,
            "2018-01-16": 9.17,
            "2018-01-17": -7.57,
            "2018-01-18": -2.97,
            "2018-01-19": 8.14,
            "2018-01-22": 3.52,
            "2018-01-23": -0.38,
            "2018-01-24": 1.15,
            "2018-01-25": 2.44,
            "2018-01-26": 1.43,
            "2018-01-29": 1.54,
            "2018-01-30": 11.73,
            "2018-01-31": 8.27,
            "2018-02-01": 5.27,
            "2018-02-02": 5.91,
            "2018-02-05": -5.39,
            "2018-02-06": -2.19,
            "2018-02-07": -13.04,
            "2018-02-08": -4.91,
            "2018-02-09": -5.7,
            "2018-02-12": 7.83,
            "2018-02-13": -11.01,
            "2018-02-14": 1.3,
            "2018-02-19": -1.67,
            "2018-02-20": 12.81,
            "2018-02-21": 2.64,
            "2018-02-22": -7.01,
            "2018-02-23": -5.7,
            "2018-02-26": -0.87,
            "2018-02-27": -17.2,
            "2018-02-28": -5.89,
            "2018-03-02": -4.83,
            "2018-03-05": -5.88,
            "2018-03-06": -4.17,
            "2018-03-07": -6.19,
            "2018-03-08": 0.64,
            "2018-03-09": -2.35,
            "2018-03-12": -7.06,
            "2018-03-13": 9.35,
            "2018-03-14": -1.66,
            "2018-03-15": -9.13,
            "2018-03-16": 0.64,
            "2018-03-19": 3.5,
            "2018-03-20": 8.14,
            "2018-03-21": 2.86,
            "2018-03-22": -20.02,
            "2018-03-23": -4.89,
            "2018-03-26": -11.18,
            "2018-03-27": -3.61,
            "2018-03-28": -4.56,
            "2018-03-29": 5.28,
            "2018-03-30": -9.5,
            "2018-04-02": -9.3,
            "2018-04-03": -12.51,
            "2018-04-04": -14.63,
            "2018-04-05": -19.71,
            "2018-04-06": -21.51,
            "2018-04-09": -10.8,
            "2018-04-10": -13.56,
            "2018-04-11": -12.5,
            "2018-04-12": -18.02,
            "2018-04-13": -24.12,
            "2018-04-16": -12.79,
            "2018-04-17": -17.8,
            "2018-04-18": -14.46,
            "2018-04-19": -10.82,
            "2018-04-20": -17.34,
            "2018-04-23": -25.4,
            "2018-04-24": -11.16,
            "2018-04-25": -12.29,
            "2018-04-26": -19.75,
            "2018-04-27": -11.22,
            "2018-04-30": -20.32,
            "2018-05-02": -14.07,
            "2018-05-03": -22.78,
            "2018-05-04": -15.05,
            "2018-05-08": -25.31,
            "2018-05-09": -15.57,
            "2018-05-10": -25.23,
            "2018-05-11": -16.71,
            "2018-05-14": -18.95,
            "2018-05-15": -17.56,
            "2018-05-16": -15.02,
            "2018-05-17": -18.4,
            "2018-05-18": -12.6,
            "2018-05-21": -14.08,
            "2018-05-23": -15.06,
            "2018-05-24": -6.46,
            "2018-05-25": -9.26,
            "2018-05-28": -23.58,
            "2018-05-29": -6.77,
            "2018-05-30": -27.9,
            "2018-05-31": -7.46,
            "2018-06-01": -3.76,
            "2018-06-04": -21.85,
            "2018-06-05": -21.74,
            "2018-06-07": -9.26,
            "2018-06-08": -19.09,
            "2018-06-11": -10.49,
            "2018-06-12": -11.94,
            "2018-06-14": -19.93,
            "2018-06-15": -13.59,
            "2018-06-18": -21.98,
            "2018-06-19": -20.62,
            "2018-06-20": -16.4,
            "2018-06-21": -4.81,
            "2018-06-22": -14.39,
            "2018-06-25": -13.71,
            "2018-06-26": -24.21,
            "2018-06-27": -24.38,
            "2018-06-28": -18.08,
            "2018-06-29": -2.67,
            "2018-07-02": -2.62,
            "2018-07-03": -0.53,
            "2018-07-04": 14.7,
            "2018-07-05": 10.51,
            "2018-07-06": -1.21,
            "2018-07-09": 3.41,
            "2018-07-10": -3.95,
            "2018-07-11": 6.76,
            "2018-07-12": 7.49,
            "2018-07-13": 3.81,
            "2018-07-16": 3.4,
            "2018-07-17": 7.15,
            "2018-07-18": 0.44,
            "2018-07-19": -13.47,
            "2018-07-20": -4.04,
            "2018-07-23": 5.7,
            "2018-07-24": 16.29,
            "2018-07-25": 2.4,
            "2018-07-26": -12.84,
            "2018-07-27": 2.56,
            "2018-07-30": 6.48,
            "2018-07-31": 1.72,
            "2018-08-01": 6.38,
            "2018-08-02": 10.53,
            "2018-08-03": -3.95,
            "2018-08-06": -1.01,
            "2018-08-07": 14.21,
            "2018-08-08": 2.73,
            "2018-08-09": 10.15,
            "2018-08-10": 6.61,
            "2018-08-13": -6.41,
            "2018-08-14": 2.81,
            "2018-08-16": -1.0,
            "2018-08-17": 8.44,
            "2018-08-20": -5.6,
            "2018-08-21": 3.24,
            "2018-08-22": 8.8,
            "2018-08-23": 15.21,
            "2018-08-24": 1.61,
            "2018-08-27": -6.2,
            "2018-08-28": -6.73,
            "2018-08-29": -5.02,
            "2018-08-30": -3.19,
            "2018-08-31": 11.16,
            "2018-09-03": 6.41,
            "2018-09-04": -0.83,
            "2018-09-05": 12.71,
            "2018-09-06": 7.41,
            "2018-09-07": -3.59,
            "2018-09-10": -0.69,
            "2018-09-11": -0.7,
            "2018-09-12": 1.32,
            "2018-09-13": 6.58,
            "2018-09-14": 7.45,
            "2018-09-17": -6.3,
            "2018-09-18": 0.62,
            "2018-09-19": -4.16,
            "2018-09-20": 0.42,
            "2018-09-21": 0.9,
            "2018-09-27": 4.3,
            "2018-09-28": 14.8,
            "2018-10-01": 14.53,
            "2018-10-02": 20.01,
            "2018-10-04": 16.41,
            "2018-10-05": 0.92,
            "2018-10-08": 2.96,
            "2018-10-10": 13.25,
            "2018-10-11": 17.3,
            "2018-10-12": 14.32,
            "2018-10-15": 12.43,
            "2018-10-16": 16.28,
            "2018-10-17": -0.87,
            "2018-10-18": -5.43,
            "2018-10-19": -0.97,
            "2018-10-22": 11.48,
            "2018-10-23": 15.61,
            "2018-10-24": 8.14,
            "2018-10-25": -3.74,
            "2018-10-26": 3.71,
            "2018-10-29": 5.95,
            "2018-10-30": 6.29,
            "2018-10-31": -0.67,
            "2018-11-01": 27.06,
            "2018-11-02": 15.83,
            "2018-11-05": 6.99,
            "2018-11-06": 8.18,
            "2018-11-07": 26.54,
            "2018-11-08": 5.8,
            "2018-11-09": 20.76,
            "2018-11-12": 5.28,
            "2018-11-13": 8.65,
            "2018-11-14": 21.49,
            "2018-11-15": 12.22,
            "2018-11-16": -4.02,
            "2018-11-19": 12.02,
            "2018-11-20": 6.89,
            "2018-11-21": 18.96,
            "2018-11-22": 15.54,
            "2018-11-23": 31.55,
            "2018-11-26": 5.76,
            "2018-11-27": 6.5,
            "2018-11-28": 6.49,
            "2018-11-29": 6.66,
            "2018-11-30": 18.1,
            "2018-12-03": 21.87,
            "2018-12-04": 5.68,
            "2018-12-05": 10.88,
            "2018-12-06": 4.4,
            "2018-12-07": 14.91,
            "2018-12-10": 14.15,
            "2018-12-11": 8.91,
            "2018-12-12": 25.09,
            "2018-12-13": 11.13,
            "2018-12-14": 12.36,
            "2018-12-17": 10.6,
            "2018-12-18": 13.09,
            "2018-12-19": 2.29,
            "2018-12-20": 25.16,
            "2018-12-21": 5.28,
            "2018-12-24": 18.94,
            "2018-12-26": 1.73,
            "2018-12-27": 9.32,
            "2018-12-28": 38.78,
            "2019-01-02": 38.11,
            "2019-01-03": 42.47,
            "2019-01-04": 61.74,
            "2019-01-07": 58.94,
            "2019-01-08": 71.05,
            "2019-01-09": 37.41,
            "2019-01-10": 39.32,
            "2019-01-11": 54.15,
            "2019-01-14": 54.86,
            "2019-01-15": 38.47,
            "2019-01-16": 71.55,
            "2019-01-17": 56.96,
            "2019-01-18": 62.72,
            "2019-01-21": 49.5,
            "2019-01-22": 55.29,
            "2019-01-23": 33.17,
            "2019-01-24": 39.79,
            "2019-01-25": 49.54,
            "2019-01-28": 54.65,
            "2019-01-29": 69.32,
            "2019-01-30": 47.09,
            "2019-01-31": 38.32,
            "2019-02-01": 64.2,
            "2019-02-07": 45.39,
            "2019-02-08": 59.21,
            "2019-02-11": 69.79,
            "2019-02-12": 34.87,
            "2019-02-13": 34.54,
            "2019-02-14": 65.2,
            "2019-02-15": 39.09,
            "2019-02-18": 45.62,
            "2019-02-19": 48.14,
            "2019-02-20": 47.86,
            "2019-02-21": 48.69,
            "2019-02-22": 45.85,
            "2019-02-25": 55.17,
            "2019-02-26": 42.27,
            "2019-02-27": 49.05,
            "2019-02-28": 51.66,
            "2019-03-04": 36.72,
            "2019-03-05": 37.05,
            "2019-03-06": 61.21,
            "2019-03-07": 55.2,
            "2019-03-08": 39.0,
            "2019-03-11": 55.64,
            "2019-03-12": 56.22,
            "2019-03-13": 54.46,
            "2019-03-14": 49.35,
            "2019-03-15": 23.14,
            "2019-03-18": 48.24,
            "2019-03-19": 65.87,
            "2019-03-20": 60.68,
            "2019-03-21": 59.75,
            "2019-03-22": 39.41,
            "2019-03-25": 56.41,
            "2019-03-26": 63.69,
            "2019-03-27": 53.5,
            "2019-03-28": 43.29,
            "2019-03-29": 43.44,
            "2019-04-01": 30.83,
            "2019-04-02": 28.84,
            "2019-04-03": 22.3,
            "2019-04-04": 18.39,
            "2019-04-05": 22.81,
            "2019-04-08": 11.91,
            "2019-04-09": 28.6,
            "2019-04-10": 29.22,
            "2019-04-11": 13.16,
            "2019-04-12": 24.32,
            "2019-04-15": 29.11,
            "2019-04-16": 25.46,
            "2019-04-17": 31.45,
            "2019-04-18": 23.51,
            "2019-04-19": 22.7,
            "2019-04-22": 31.26,
            "2019-04-23": 15.47,
            "2019-04-24": 24.84,
            "2019-04-25": 16.81,
            "2019-04-26": 23.0,
            "2019-04-29": 32.43,
            "2019-04-30": 24.96
        },
        "승률": 61.42
    },
     */
}