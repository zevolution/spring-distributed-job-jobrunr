package dev.zevolution.springdistributedjobjobrunr.adapter.datasources;

import dev.zevolution.springdistributedjobjobrunr.internal.entities.Sample;
import dev.zevolution.springdistributedjobjobrunr.bootstrap.exceptions.NotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class SampleDataSourceTest {

    @Test
    public void shouldReturnFirstExample() {
        SampleDataSource sampleDataSource = new SampleDataSource();
        Sample sample = sampleDataSource.getSample(1);
        Assert.assertEquals("First Example", sample.getDescription());
    }

    @Test
    public void shouldReturnSecondExample() {
        SampleDataSource sampleDataSource = new SampleDataSource();
        Sample sample = sampleDataSource.getSample(2);
        Assert.assertEquals("Second Example", sample.getDescription());
    }

    @Test(expected = NotFoundException.class)
    public void shouldThrowNotFoundExceptionWhenFindNullSample() {
        SampleDataSource sampleDataSource = new SampleDataSource();
        sampleDataSource.getSample(null);
    }

}