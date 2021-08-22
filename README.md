# app1

## API 1.0 Usage
------
``` python
@GetMapping(path = "top/{ticker}/{num}")
  """
  sort the data in ascending order, retrieve the first specified 
  number of records for that particular ticker
  """
```
```python
@GetMapping(path = "tail/{ticker}/{num}")
  """ 
  sort the data in descending order, retrieve the first specified 
  number of records for that particular ticker 
  """
```

```python
@GetMapping(path= "tickers/{ticker_List}")
  """ 
  There are several valid formats for this path:
     1.if you just append the list of tickers' names without giving anything else, 
     it will retrieve all the records stored in the db for that particular list of tickers.
     
     2.a fromDate may also be added after the ticker list, for example, 
     tickers/A,AAL?fromDate=2010-01-04, then it will retrieve all
     the records stored in the db for that particular list of tickers from that day on.
     
     3.similarly, a toDate may also be added, for example, 
     tickers/A,AAL?toDate=2010-01-04, then it will retrieve all the records
     stored in the db for that particular list of tickers to that day.
     
     4. fromDate and toDate may be added at the same time, for example, 
     tickers/A,AAL?fromDate=2020-12-05 & toDate=2020-12-31, then, it will
     retrieve all the records stored in the db for that particular list of tickers
     between these two date(inclusive).
  """
```

```python
 @GetMapping(path="open_close_view/{ticker}")
  """ 
  similar as the one above but only show open close columns for one particular 
  given ticker
  """
```
```python
 @GetMapping(path="high_low_view/{ticker}")
  """ 
  similar as the one above but only show high low columns for one particular 
  given ticker
  """
```


