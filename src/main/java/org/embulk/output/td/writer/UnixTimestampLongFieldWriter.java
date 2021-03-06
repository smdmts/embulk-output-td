package org.embulk.output.td.writer;

import org.embulk.output.td.MsgpackGZFileBuilder;
import org.embulk.spi.Column;
import org.embulk.spi.PageReader;

import java.io.IOException;

public class UnixTimestampLongFieldWriter
        extends FieldWriter
{
    private final int fractionUnit;

    public UnixTimestampLongFieldWriter(String keyName, int fractionUnit)
    {
        super(keyName);
        this.fractionUnit = fractionUnit;
    }

    @Override
    public void writeValue(MsgpackGZFileBuilder builder, PageReader reader, Column column)
            throws IOException
    {
        builder.writeLong(reader.getLong(column) / fractionUnit);
    }
}
